package com.boteking.boteking.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByTokenValue(String tokenValue);
    @Query("""
            SELECT t FROM Token t INNER JOIN User u ON t.user.id = u.id
            WHERE u.id = :userId AND (t.expired = FALSE OR t.revoked = FALSE)
            """)
    List<Token> findAllValidTokensByUser(Integer userId);
}