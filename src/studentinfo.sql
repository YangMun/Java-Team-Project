-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 21-11-20 16:25
-- 서버 버전: 8.0.26
-- PHP 버전: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `ysu`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `studentinfo`
--

CREATE TABLE `studentinfo` (
  `jumin` varchar(15) primary key,
  `name` varchar(10) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `phoneno` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 테이블의 덤프 데이터 `studentinfo`
--

INSERT INTO `studentinfo` (`jumin`, `name`, `address`, `phoneno`) VALUES
('210101-1234567', '김철수', '서울시 서초구 FFF동 222-777호', '02-540-0000'),
('210202-1324567', '박철규', '경기도 고양시 일산서구 HHH동 999-888호', '031-915-0000'),
('210303-2634673', '변재희', '서울시 마포구 EEE동 555-333호', '02-715-0000'),
('210404-4737854', '김미경', '서울시 서대문구 BCD동 333-444 l아파트 811동 707호', '02-326-0000'),
('210505-9842732', '진석영', '인천시 계양구 DDD동 000-000호', '032-702-0000'),
('210606-3029523', '박지영', '경기도 성남시 분당구 BBB동 333-444 J아파트 11-222동', '031-541-0000'),
('210707-8572832', '김재영', '서울시 동대문구 AAA동 11-22호', '02-958-0000');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
