package com.star.library_project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.star.library_project.model.Borrowing;
import com.star.library_project.model.BorrowingStatus;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    List<Borrowing> findByUserId(Long userId);

    List<Borrowing> findByBookId(Long bookId);

    List<Borrowing> findByStatus(BorrowingStatus status);

    @Query("SELECT b FROM Borrowing b WHERE b.dueDate < :currentDate AND b.returnDate IS NULL")
    List<Borrowing> findOverdueBorrowings(@Param("currentDate") LocalDate currentDate);

    @Query("SELECT b FROM Borrowing b WHERE b.returnDate IS NULL")
    List<Borrowing> findActiveBorrowings();

    @Query("SELECT b FROM Borrowing b WHERE b.user.id = :userId AND b.returnDate IS NULL")
    List<Borrowing> findActiveBorrowingsByUser(@Param("userId") Long userId);

    @Query("SELECT b FROM Borrowing b WHERE b.book.id = :bookId AND b.returnDate IS NULL")
    List<Borrowing> findActiveBorrowingsByBook(@Param("bookId") Long bookId);
}
