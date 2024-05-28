package com.souza.projeto.services;
import com.souza.projeto.entities.User;
import com.souza.projeto.repositories.UserRepository;
import com.souza.projeto.services.exceptions.DatabaseException;
import com.souza.projeto.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceTest {
    User user;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Test
    @DisplayName("should find with successfully")
    void findByIdsSuccessfully() {
        //arrange
        Optional<User> optionalUser = Optional.of(user);
        User out;
        Mockito.when(userRepository.findById(anyLong())).thenReturn(optionalUser);
        //act
        out = userService.findById(optionalUser.get().getId());
        //assert
        Assert.notNull(out,"should find with successfully");
        assertEquals(out.getName(), user.getName(), "The user should be the same");
    }

    @Test
    @DisplayName("should throw ResourceNotFoundException")
    void findByIdsFailure() {
        //arrange
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        //act&assert
        var x = Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.findById(9L));
        assertTrue(x.getMessage().contains(""+9L));
    }

    @Test
    @DisplayName("should insert with successfully")
    void insertSuccessfully() {
        //arrange
        var input01 = new User();
        input01.setName("Fred");
        input01.setEmail("fred@gmail.com");
        input01.setPhone("123456789");
        input01.setPassword("********");
        doReturn(input01).when(userRepository).save(userArgumentCaptor.capture());
        //act
        var out = userService.insert(input01);

        //assert
        Assert.notNull(out, "successfully");
        var captor = userArgumentCaptor.getValue();
        assertEquals(input01.getName(), captor.getName());
    }

    @Test()
    @DisplayName("should throw DataIntegrityViolationException when data integrity is compromised (email)")
    void insertFailure() {
        //arrange
        User input01 = new User();
        input01.setName("Fred");
        input01.setEmail("fred@gmail.com");
        input01.setPhone("123456789");
        input01.setPassword("********");
        Mockito.when(userRepository.save(input01)).thenReturn(input01);
        Mockito.when(userService.insert(input01)).thenThrow(DataIntegrityViolationException.class);

        //act & assert
        var ex = Assertions.assertThrows(DatabaseException.class, () -> userService.insert(input01));
        verify(userRepository).save(input01);
        assertTrue(ex.getMessage().contains(input01.getEmail()));
    }

    @Test
    @DisplayName("should delete the user successfully")
    void deleteSuccessfully() {
        //arrange
        var input01 = new User();
        input01.setId(3L);
        doNothing().when(userRepository).deleteById(input01.getId());

        userService.delete(input01.getId());
        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    @DisplayName("should throw ResourceNotFoundException when id does not exist in database")
    void deleteFailureCase01() {
        //arrange
        var input01 = new User();
        input01.setId(3L);
        doThrow(EmptyResultDataAccessException.class).when(userRepository).deleteById(anyLong());
        //act
        var ex = Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.delete(input01.getId()));
        verify(userRepository, times(1)).deleteById(anyLong());
        //assert
        assertTrue(ex.getMessage().contains(""+input01.getId()));
    }

    @Test
    @DisplayName("should throw DatabaseException when Referential Integrity is compromised")
    void deleteFailureCase02() {
        //arrange
        var input01 = new User();
        input01.setId(3L);
        doThrow(DataIntegrityViolationException.class).when(userRepository).deleteById(anyLong());
        //act
        var ex = Assertions.assertThrows(DatabaseException.class, () -> userService.delete(input01.getId()));
        verify(userRepository, times(1)).deleteById(anyLong());

        //assert
        assertTrue(ex.getMessage().contains(""+input01.getId()));
    }

    @Test
    @DisplayName("should update the user successfully")
    void updateSuccessfully() {
        //arrange
        var input01 = new User();
        var out = Mockito.when(userRepository.getReferenceById(anyLong())).thenReturn(user);
        Mockito.when(userRepository.save(any())).thenReturn(out);

        //act
        //assert

    }

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(3L);
        user.setName("Jason");
        user.setEmail("Jason@gmail.com");
        user.setPhone("123456789");
        user.setPassword("********");
    }


}