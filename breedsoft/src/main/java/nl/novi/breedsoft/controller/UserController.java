package nl.novi.breedsoft.controller;

import jakarta.validation.Valid;
import nl.novi.breedsoft.dto.userDtos.UserInputDto;
import nl.novi.breedsoft.dto.userDtos.UserOutputDto;
import nl.novi.breedsoft.dto.userDtos.UserPatchDto;
import nl.novi.breedsoft.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static nl.novi.breedsoft.utility.BindingResultErrorUtility.bindingResultError;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<UserOutputDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserInputDto userInputDto, BindingResult br){
        //If there is an error in the binding
        if(br.hasErrors()){
            return bindingResultError(br);
        }else{
            Long createdId = userService.createUser(userInputDto);
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/users/" + createdId).toUriString());
            return ResponseEntity.created(uri).body("User is successfully created!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchUser(@PathVariable("id") Long id, @Valid @RequestBody UserPatchDto userPatchDto, BindingResult br){
        //If there is an error in the binding
        if (br.hasErrors()) {
            return bindingResultError(br);
        } else {
            UserOutputDto userOutputDto = userService.patchUser(id, userPatchDto);
            return ResponseEntity.ok().body(userOutputDto);
        }
    }
}
