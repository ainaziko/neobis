package com.production.stock.appuser;




import com.production.stock.model.AppUserModel;
import com.production.stock.registration.token.ConfirmationToken;

import com.production.stock.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        appUser.setEnabled(true);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findById(Long id){
        return appUserRepository.findById(id);
    }

    public AppUser addUser(AppUserModel model){
        AppUser appUser = new AppUser(model.getFirstName(), model.getLastName(), model.getEmail(), model.getPassword(), model.getAppUserRole());
        appUserRepository.save(appUser);
        return appUser;
    }

    public AppUser edit(Long id, AppUserModel model) throws Exception {
        return appUserRepository.findById(id)
                .map(edit -> {
                    edit.setFirstName(model.getFirstName());
                    edit.setLastName(model.getLastName());
                    edit.setEmail(model.getEmail());
                    //edit.setPassword(model.getPassword());
                    //edit.setAppUserRole(model.getAppUserRole());
                    return appUserRepository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        appUserRepository.deleteById(id);
        return "Deleted";
    }

}
