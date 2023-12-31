package com.specific.group.gamification.game;

import com.specific.group.gamification.game.domain.LeaderBoardRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class implements a REST API for the Gamification LeaderBoard service.
 */

@Slf4j
@RestController
@RequestMapping("/leaders")
@RequiredArgsConstructor
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;
    @GetMapping
    public List<LeaderBoardRow> getLeaderBoard() {
        log.info("Retrieving leaderboard");
        List<LeaderBoardRow> currentLeaderBoard = leaderBoardService.getCurrentLeaderBoard();
        log.info("Retrieving leaderboard currentLeaderBoard: {}", currentLeaderBoard);
        return currentLeaderBoard;
    }
}
