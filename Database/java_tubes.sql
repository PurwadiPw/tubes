-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 29, 2017 at 09:58 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31-6+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_tubes`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `jdwl_per_dosen` (IN `kd_Dsn` CHAR(8))  BEGIN
SELECT distinct NM_HARI, JAM_MULAI, JAM_AKHIR, NM_MATKUL, NM_KELAS
FROM JadwalKuliah
Where KD_DOSEN = kd_Dsn
order by ID_HARI, ID_SESI;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `cekNgajar` (`kd_dsn` CHAR(8), `hari` VARCHAR(10)) RETURNS VARCHAR(100) CHARSET latin1 BEGIN
DECLARE jumlah INT;
SELECT COUNT(ID_SESI) INTO jumlah FROM JadwalKuliah
WHERE KD_DOSEN = kd_dsn and NM_HARI = hari;
IF (jumlah > 0) THEN
RETURN CONCAT("Kode Dosen ", kd_dsn, " mengajar ", jumlah, " jam di hari " , hari);
ELSE
RETURN CONCAT("Kode Dosen dimaksud tidak ngajar di hari ", hari);
END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `KD_DOSEN` char(6) NOT NULL,
  `NM_DOSEN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`KD_DOSEN`, `NM_DOSEN`) VALUES
('DU004N', 'N.S. Junaedi E'),
('DU061N', 'Suyamto'),
('IG011N', 'Lina Meilina'),
('IG016N', 'Nita Herlina'),
('KO001N', 'Ade Chandra Nugraha'),
('KO002N', 'Ani Rahmani'),
('KO003N', 'Bambang wisnuadhi'),
('KO007N', 'Joe Lian Min'),
('KO008N', 'Nurjannah Syakrani'),
('KO009N', 'Santi Sundari'),
('KO011N', 'Tati Susilawati'),
('KO012N', 'Urip T. Setijohatmo'),
('KO013N', 'Yudi Widhiyasana'),
('KO014N', 'Amir Hamzah'),
('KO016N', 'Eddy B. Soewono'),
('KO017N', 'Ferry Feirizal'),
('KO018N', 'Jonner Hutahaean'),
('KO019N', 'Transmissia Semiawan'),
('KO021N', 'Setiadi Rachmat'),
('KO022N', 'Suprihanto'),
('KO023N', 'Iwan Awaludin'),
('KO045N', 'Irwan Setiawan'),
('KO050N', 'Ade Hodijah'),
('KO056N', 'Ida Suhartini'),
('KO057N', 'Fitri Diani'),
('KO059N', 'Ghifari Munawal'),
('KO061N', 'Zulkifli Arsyad'),
('KO062K', 'Rahil Jumiyani'),
('KO066N', 'Irawan Thamrin');

-- --------------------------------------------------------

--
-- Table structure for table `hari`
--

CREATE TABLE `hari` (
  `ID_HARI` int(11) NOT NULL,
  `NM_HARI` varchar(6) NOT NULL,
  `kd_dosen` varchar(255) NOT NULL,
  `nm_dosen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hari`
--

INSERT INTO `hari` (`ID_HARI`, `NM_HARI`, `kd_dosen`, `nm_dosen`) VALUES
(1, 'Senin', '', NULL),
(2, 'Selasa', '', NULL),
(3, 'Rabu', '', NULL),
(4, 'Kamis', '', NULL),
(5, 'Jumat', '', NULL),
(6, 'Sabtu', '', NULL),
(7, 'Minggu', '', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `KD_JADWAL` int(10) NOT NULL,
  `KD_MATKUL` varchar(9) DEFAULT NULL,
  `JENIS` char(2) DEFAULT NULL,
  `KD_DOSEN` char(6) DEFAULT NULL,
  `KD_RUANG` char(4) DEFAULT NULL,
  `TAHUN` char(9) DEFAULT NULL,
  `NM_KELAS` char(2) DEFAULT NULL,
  `ID_SESI` int(11) DEFAULT NULL,
  `ID_HARI` int(11) DEFAULT NULL,
  `NM_DOSEN` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `jadwalkuliah`
--
CREATE TABLE `jadwalkuliah` (
`ID_HARI` int(11)
,`NM_HARI` varchar(6)
,`NM_KELAS` char(2)
,`ID_SESI` int(11)
,`JAM_MULAI` time
,`JAM_AKHIR` time
,`KD_MATKUL` varchar(9)
,`NM_MATKUL` varchar(30)
,`JENIS` char(2)
,`KD_DOSEN` char(6)
,`NM_DOSEN` varchar(20)
,`KD_RUANG` char(4)
,`NM_RUANG` varchar(15)
);

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `NM_KELAS` char(2) NOT NULL,
  `PRODI` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`NM_KELAS`, `PRODI`) VALUES
('1A', 'D3'),
('1B', 'D3'),
('1C', 'D4'),
('2A', 'D3'),
('2B', 'D3'),
('2C', 'D4'),
('3A', 'D3'),
('3B', 'D3'),
('3C', 'D4'),
('4C', 'D4');

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `KD_MATKUL` varchar(9) NOT NULL,
  `NM_MATKUL` varchar(30) NOT NULL,
  `JENIS` char(2) NOT NULL,
  `SKS` int(11) NOT NULL,
  `VERSION` varchar(512) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`KD_MATKUL`, `NM_MATKUL`, `JENIS`, `SKS`, `VERSION`) VALUES
('16KI11022', 'Bahasa Inggris 1', 'PR', 2, NULL),
('16KI11022', 'Bahasa Inggris 1', 'TE', 2, NULL),
('16KI11032', 'Bahasa Inggris 1', 'PR', 2, NULL),
('16KI11032', 'Bahasa Inggris 1', 'TE', 2, NULL),
('16KI11077', 'Pemrograman Visual', 'PR', 2, '0'),
('16KI33062', 'Kewirausahaan', 'TE', 2, NULL),
('16KU23032', 'Pendidikan Pancasila', 'TE', 2, NULL),
('16KU23052', 'Pendidikan Pancasila', 'TE', 2, NULL),
('16KU41012', 'Bahasa Indonesia', 'TE', 2, NULL),
('16TIN1034', 'Dasar-Dasar Pemrograman', 'PR', 4, NULL),
('16TIN1034', 'Dasar-Dasar Pemrograman', 'TE', 4, NULL),
('16TIN1043', 'Matematika Terapan 1', 'PR', 3, NULL),
('16TIN1043', 'Matematika Terapan 1', 'TE', 3, NULL),
('16TIN1052', 'Komputasi Kognitif', 'PR', 2, NULL),
('16TIN1052', 'Komputasi Kognitif', 'TE', 2, NULL),
('16TIN1064', 'Konsep Teknologi Informasi dan', 'PR', 4, NULL),
('16TIN1064', 'Konsep Teknologi Informasi dan', 'TE', 4, NULL),
('16TIN1073', 'Matematika Diskrit 1', 'PR', 3, NULL),
('16TIN1073', 'Matematika Diskrit 1', 'TE', 3, NULL),
('16TIN3013', 'Arsitektur dan Organisasi Komp', 'PR', 3, NULL),
('16TIN3013', 'Arsitektur dan Organisasi Komp', 'TE', 3, NULL),
('16TIN3023', 'Matematika Diskrit 2', 'PR', 3, NULL),
('16TIN3023', 'Matematika Diskrit 2', 'TE', 3, NULL),
('16TIN3043', 'Matematika Terapan 2', 'PR', 3, NULL),
('16TIN3043', 'Matematika Terapan 2', 'TE', 3, NULL),
('16TIN3053', 'Sistem Basis Data', 'PR', 3, NULL),
('16TIN3053', 'Sistem Basis Data', 'TE', 3, NULL),
('16TIN3063', 'Prinsip Bahasa Pemrograman', 'PR', 3, NULL),
('16TIN3063', 'Prinsip Bahasa Pemrograman', 'TE', 3, NULL),
('16TIN3073', 'Komunikasi Data dan Jaringan', 'PR', 3, NULL),
('16TIN3073', 'Komunikasi Data dan Jaringan', 'TE', 3, NULL),
('16TKO1012', 'Pengantar Ilmu Lingkungan', 'TE', 2, NULL),
('16TKO1022', 'Dasar Komunikasi', 'TE', 2, NULL),
('16TKO1042', 'Matematika Terapan 1', 'PR', 2, NULL),
('16TKO1042', 'Matematika Terapan 1', 'TE', 2, NULL),
('16TKO1054', 'Dasar-Dasar Pemrograman', 'PR', 4, NULL),
('16TKO1054', 'Dasar-Dasar Pemrograman', 'TE', 4, NULL),
('16TKO1062', 'Ilmu Komputer', 'PR', 2, NULL),
('16TKO1062', 'Ilmu Komputer', 'TE', 2, NULL),
('16TKO1073', 'Matematika Diskrit 1', 'PR', 3, NULL),
('16TKO1073', 'Matematika Diskrit 1', 'TE', 3, NULL),
('16TKO1083', 'Proyek 1', 'PR', 3, NULL),
('16TKO3014', 'Basis Data', 'PR', 4, NULL),
('16TKO3014', 'Basis Data', 'TE', 4, NULL),
('16TKO3024', 'Pengantar Rekaya Perangkat Lun', 'PR', 4, NULL),
('16TKO3024', 'Pengantar Rekaya Perangkat Lun', 'TE', 4, NULL),
('16TKO3033', 'Aljabar Liniear', 'PR', 3, NULL),
('16TKO3033', 'Aljabar Liniear', 'TE', 3, NULL),
('16TKO3043', 'Pemrograman Berorientasi Objek', 'PR', 3, NULL),
('16TKO3043', 'Pemrograman Berorientasi Objek', 'TE', 3, NULL),
('16TKO3073', 'Proyek 3', 'PR', 3, NULL),
('KBTI3024', 'Pengembangan Perangkat Lunak 2', 'PR', 4, NULL),
('KBTI3024', 'Pengembangan Perangkat Lunak 2', 'TE', 4, NULL),
('KBTI3142', 'Kerja Praktek', 'PR', 2, NULL),
('KBTI3153', 'Proyek 5', 'PR', 3, NULL),
('KBTI4513', 'Komputer Grafik', 'PR', 3, NULL),
('KBTI4513', 'Komputer Grafik', 'TE', 3, NULL),
('KBTI4554', 'Sistem Informasi', 'PR', 4, NULL),
('KBTI4554', 'Sistem Informasi', 'TE', 4, NULL),
('KBTI4574', 'Pemrograman Web', 'PR', 4, NULL),
('KBTI4574', 'Pemrograman Web', 'TE', 4, NULL),
('KBTI4714', 'Praktek Kerja Lapangan 1', 'PR', 4, NULL),
('KBTI4722', 'Praktek Kerja Lapangan 2', 'PR', 2, NULL),
('KBTI4734', 'Proyek 4', 'PR', 4, NULL),
('KKTI3103', 'Komputasi Numerik', 'PR', 3, NULL),
('KKTI3103', 'Komputasi Numerik', 'TE', 3, NULL),
('KKTI4543', 'Komputasi Numerik', 'PR', 3, NULL),
('KKTI4543', 'Komputasi Numerik', 'TE', 3, NULL),
('KKTI4563', 'Statistika dan Probabilitas', 'PR', 3, NULL),
('KKTI4563', 'Statistika dan Probabilitas', 'TE', 3, NULL),
('KKTI4583', 'Manajemen Proyek Perangkat Lun', 'PR', 3, NULL),
('KKTI4583', 'Manajemen Proyek Perangkat Lun', 'TE', 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `ruang`
--

CREATE TABLE `ruang` (
  `KD_RUANG` char(4) NOT NULL,
  `NM_RUANG` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruang`
--

INSERT INTO `ruang` (`KD_RUANG`, `NM_RUANG`) VALUES
('D101', 'Kelas Edit'),
('D102', 'Lab. MT'),
('D105', 'Kelas'),
('D106', 'Lab. SDB'),
('D107', 'Lab. RPL'),
('D108', 'Kelas'),
('D111', 'Kelas'),
('D112', 'Kelas'),
('D115', 'Lab. ICT-1'),
('D116', 'Lab. ICT-2'),
('D217', 'Kelas'),
('D219', 'Kelas'),
('D223', 'Kelas'),
('D224', 'Kelas'),
('GDH2', 'Gedung H-lt2'),
('GDH3', 'Gedung H-lt3');

-- --------------------------------------------------------

--
-- Table structure for table `sesi`
--

CREATE TABLE `sesi` (
  `ID_SESI` int(11) NOT NULL,
  `JAM_MULAI` time NOT NULL,
  `JAM_AKHIR` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sesi`
--

INSERT INTO `sesi` (`ID_SESI`, `JAM_MULAI`, `JAM_AKHIR`) VALUES
(1, '07:00:00', '07:50:50'),
(2, '07:50:00', '08:40:00'),
(3, '08:40:00', '09:30:00'),
(4, '09:30:00', '10:20:00'),
(5, '10:40:00', '11:30:00'),
(6, '11:30:00', '12:20:00'),
(7, '13:00:00', '13:50:00'),
(8, '13:50:00', '14:40:00'),
(9, '14:40:00', '15:20:00'),
(10, '15:20:00', '16:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `tahun_akademik`
--

CREATE TABLE `tahun_akademik` (
  `TAHUN` char(9) NOT NULL,
  `SEMESTER` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tahun_akademik`
--

INSERT INTO `tahun_akademik` (`TAHUN`, `SEMESTER`) VALUES
('2017/2018', 'GANJIL');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) VALUES
(1, 1, 'purwadie97@gmail.com', 'Pw', 'Purwadi', '$2a$10$b/Upvd3R/25hqqooeZ8ah.oSnMULgCkJaYUb3ilpp9mFzvHlFva.2');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure for view `jadwalkuliah`
--
DROP TABLE IF EXISTS `jadwalkuliah`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `jadwalkuliah`  AS  select `hari`.`ID_HARI` AS `ID_HARI`,`hari`.`NM_HARI` AS `NM_HARI`,`kelas`.`NM_KELAS` AS `NM_KELAS`,`sesi`.`ID_SESI` AS `ID_SESI`,`sesi`.`JAM_MULAI` AS `JAM_MULAI`,`sesi`.`JAM_AKHIR` AS `JAM_AKHIR`,`matkul`.`KD_MATKUL` AS `KD_MATKUL`,`matkul`.`NM_MATKUL` AS `NM_MATKUL`,`matkul`.`JENIS` AS `JENIS`,`dosen`.`KD_DOSEN` AS `KD_DOSEN`,`dosen`.`NM_DOSEN` AS `NM_DOSEN`,`ruang`.`KD_RUANG` AS `KD_RUANG`,`ruang`.`NM_RUANG` AS `NM_RUANG` from ((((((`dosen` join `matkul`) join `jadwal`) join `ruang`) join `sesi`) join `hari`) join `kelas`) where ((`dosen`.`KD_DOSEN` = `jadwal`.`KD_DOSEN`) and (`matkul`.`KD_MATKUL` = `jadwal`.`KD_MATKUL`) and (`ruang`.`KD_RUANG` = `jadwal`.`KD_RUANG`) and (`sesi`.`ID_SESI` = `jadwal`.`ID_SESI`) and (`kelas`.`NM_KELAS` = `jadwal`.`NM_KELAS`) and (`hari`.`ID_HARI` = `jadwal`.`ID_HARI`) and (`matkul`.`JENIS` = `jadwal`.`JENIS`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`KD_DOSEN`),
  ADD UNIQUE KEY `DOSEN_PK` (`KD_DOSEN`);

--
-- Indexes for table `hari`
--
ALTER TABLE `hari`
  ADD PRIMARY KEY (`ID_HARI`),
  ADD UNIQUE KEY `HARI_PK` (`ID_HARI`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`KD_JADWAL`),
  ADD KEY `RELATIONSHIP_1_FK` (`KD_MATKUL`,`JENIS`),
  ADD KEY `RELATIONSHIP_2_FK` (`ID_SESI`),
  ADD KEY `RELATIONSHIP_3_FK` (`NM_KELAS`),
  ADD KEY `RELATIONSHIP_4_FK` (`ID_HARI`),
  ADD KEY `RELATIONSHIP_5_FK` (`TAHUN`),
  ADD KEY `RELATIONSHIP_6_FK` (`KD_DOSEN`),
  ADD KEY `RELATIONSHIP_7_FK` (`KD_RUANG`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`NM_KELAS`),
  ADD UNIQUE KEY `KELAS_PK` (`NM_KELAS`);

--
-- Indexes for table `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`KD_MATKUL`,`JENIS`),
  ADD UNIQUE KEY `MATKUL_PK` (`KD_MATKUL`,`JENIS`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `ruang`
--
ALTER TABLE `ruang`
  ADD PRIMARY KEY (`KD_RUANG`),
  ADD UNIQUE KEY `RUANG_PK` (`KD_RUANG`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `KD_JADWAL` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
