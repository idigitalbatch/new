
//package com.example.TestService;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.exception.DuplicateEntryException;
//import com.example.exception.ResourceNotFoundException;
//import com.example.model.Cart;
//import com.example.model.User;
//import com.example.repository.CartRepository;
//import com.example.repository.UserRepository;
//import com.example.serviceimplementation.UserServiceImpl;
//
//
//
//
//@ContextConfiguration(classes = {UserServiceImpl.class})
//@ExtendWith(SpringExtension.class)
//public class UserServiceTest {
//
//
//    @MockBean
//    private CartRepository cartRepository;
//
//    @Autowired
//    UserServiceImpl userService;
//
//    @MockBean
//    UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        User user =
//                User.builder()
//                        .emailId("Sandhiya@gmail.com")
//                        .name("Sandhiya")
//                        .UserrId(1)
//                        .password("Sandhiya123")
//                        .build();
//
//        Mockito.when(userRepository.findByEmailIdAndPassword("Sandhiya@gmail.com", "Sandhiya123")).thenReturn(user);
//
//    }
//
//
//    //Save User Test
//    @Test
//    void saveUserDetails() {
//        User inputUser =
//                User.builder()
//                        .emailId("Sandhiya@gmail.com")
//                        .name("Sandhiya")
//                        .password("Sandhiya123")
//                        .build();
//
//        Mockito.when(userRepository.findByEmailId("Sandhiya@gmail.com")).thenReturn(null);
//        Mockito.when(userRepository.save(inputUser)).thenReturn(inputUser);
//
//        assertEquals(inputUser, userService.SaveUserDetails(inputUser));
//
//    }
//
//    //Testing Save user is throwing DuplicateEntry Exception.
//
//    @Test
//    void SaveUserDetailsException() throws DuplicateEntryException {
//        User inputUser =
//                User.builder()
//                        .emailId("Sandhiya@gmail.com")
//                        .name("Sandhiya")
//                        .password("Sandhiya123")
//                        .build();
//
//        Mockito.when(userRepository.findByEmailId("Sandhiya@gmail.com")).thenReturn(inputUser);
//        Mockito.when(userRepository.save(inputUser)).thenReturn(inputUser);
//
//        assertThrows(DuplicateEntryException.class, () -> userService.SaveUserDetails(inputUser));
//
//    }
//
//
//    @Test
//    void fetchUserByemailIdAndPassword() {
//        User userr =
//                User.builder()
//                        .emailId("Sandhiya@gmail.com")
//                        .password("Sandhiya123")
//                        .build();
//        User user1 = userService.fetchUserByemailIdAndPassword(userr);
//
//        assertEquals(user1.getEmailId(), userr.getEmailId());
//        assertEquals(user1.getPassword(), userr.getPassword());
//
//
//    }
//
//
//
//    
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testFetchById2() throws ResourceNotFoundException {
//
//
//        when(userRepository.findById((Integer) any())).thenReturn(null);
//        userService.fetchById(1);
//    }
//
//    /**
//     * Method under test: {@link UserrService#fetchById(int)}
//     */
//    @Test
//    void testFetchById3() throws ResourceNotFoundException {
//        when(userRepository.findById((Integer) any()))
//                .thenThrow(new DuplicateEntryException("Resource Name", "Field Name", "Field Value"));
//        assertThrows(DuplicateEntryException.class, () -> userService.fetchById(1));
//        verify(userRepository).findById((Integer) any());
//    }
//
//    /**
//     * Method under test: {@link UserrService#addOrder(int, String)}
//     */
//    @Test
//    void testAddOrder() {
//        Cart cart = new Cart();
//        cart.setBslid(1);
//        cart.setCartId(123);
//        cart.setUserid(1);
//        when(cartRepository.save((Cart) any())).thenReturn(cart);
//
//        User userr = new User();
//        userr.setEmailId("42");
//        userr.setName("Name");
//        userr.setPassword("Sample");
//        userr.setUserrId(123);
//        when(userRepository.findByEmailId((String) any())).thenReturn(userr);
//        assertSame(cart, userService.addOrder(123, "ram.ya@example.org"));
//        verify(cartRepository).save((Cart) any());
//        verify(userRepository).findByEmailId((String) any());
//    }
//
//
//    @Test
//    void testAddOrder2() {
//        when(cartRepository.save((Cart) any()))
//                .thenThrow(new DuplicateEntryException("Resource Name", "Field Name", "Field Value"));
//
//        User user = new User();
//        user.setEmailId("42");
//        user.setName("Name");
//        user.setPassword("Sample");
//        user.setUserrId(123);
//        when(userRepository.findByEmailId((String) any())).thenReturn(user);
//        assertThrows(DuplicateEntryException.class, () -> userService.addOrder(123, "ram.ya@example.org"));
//        verify(cartRepository).save((Cart) any());
//        verify(userRepository).findByEmailId((String) any());
//    }
//
//}
