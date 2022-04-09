package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MyDonutShopTest {
    MyDonutShop myDonutShop;
    @Mock
    DeliveryService deliveryService;
    @Mock
    PaymentService paymentService;
    @Mock
    BakeryService bakeryService;





    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myDonutShop = new MyDonutShop(paymentService,deliveryService,bakeryService);
        List<MyDonutShop> availableDonutShops = Collections.singletonList(myDonutShop);

        
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    int donutsInOrder = 10;
    Order order = new Order("Bob","8580000000",10,10.00,"10000",true);
    when(paymentService.charge(order)).thenReturn(true);
    when(bakeryService.getDonutsRemaining()).thenReturn(20);


        //when
        myDonutShop.openForTheDay();
        myDonutShop.takeOrder(order);
        //then
        verify(deliveryService, times(1)).scheduleDelivery(order);
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
        int Donuts = 2;

        Order order = new Order("Bob","8580000000",10,10.00,"10000",true);
        when(paymentService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(1);
        //when
        myDonutShop.openForTheDay();


        //then
        Throwable throwable = assertThrows(IllegalArgumentException.class,()->myDonutShop.takeOrder(order));
        assertEquals(throwable.getMessage(),"Insufficient donuts remaining");
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
        myDonutShop.closeForTheDay();
        Order order = new Order("Bob","8580000000",10,10.00,"10000",true);
        when(paymentService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(1);

        //when

        //then
    }

}