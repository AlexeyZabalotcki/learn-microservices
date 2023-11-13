package com.specific.group.gamification.game;

import com.specific.group.gamification.game.domain.LeaderBoardRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private final ScoreRepository scoreRepository;
    private final BadgeRepository badgeRepository;

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        // Get score only
        List<LeaderBoardRow> scoreOnly = scoreRepository.findFirst10();
        log.info("Service Retrieving leaderboard scoreOnly: {}", scoreOnly);
        // Combine with badges
        log.info("Service Retrieving leaderboard");
        return scoreOnly.stream().map(row -> {
            List<String> badges =
                    badgeRepository.findByUserIdOrderByBadgeTimestampDesc(
                                    row.getUserId()).stream()
                            .map(b -> b.getBadgeType().getDescription())
                            .collect(Collectors.toList());
            log.info("Service Retrieving leaderboard 1 badges {}", badges);
            return row.withBadges(badges);
        }).collect(Collectors.toList());
    }
}
