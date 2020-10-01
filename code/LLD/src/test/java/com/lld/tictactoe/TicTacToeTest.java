//package com.lld.tictactoe;
//
//import com.lld.tictactoe.model.Board;
//import com.lld.tictactoe.model.Player;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Random;
//
//import static org.mockito.Mockito.*;
//
///**
// * @author tania.gupta
// * @date 25/06/20
// */
//class TicTacToeTest {
//    @Mock
//    Player p1;
//    @Mock
//    Player p2;
//    @Mock
//    Board board;
//    @Mock
//    Random random;
//    @InjectMocks
//    TicTacToe ticTacToe;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testMain() {
//        when(p1.getSymbol()).thenReturn(0);
//        when(p2.getSymbol()).thenReturn(0);
//        when(board.getPosition()).thenReturn(new int[]{0});
//        when(board.getRowSum()).thenReturn(new int[]{0});
//        when(board.getColSum()).thenReturn(new int[]{0});
//        when(board.getDiagonalSum()).thenReturn(0);
//        when(board.getReverseDiagonalSum()).thenReturn(0);
//
//        TicTacToe.main(new String[]{"args"});
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme