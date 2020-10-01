package com.lld.chess.Controller;

import com.lld.chess.model.Move;
import com.lld.chess.model.Player;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tania.gupta
 * @date 16/08/20
 */

@RestController("/service/chess")
public class GameController {

    @PostMapping("move")
    public String move(Move move, Player player){

        return "";
    }
}
