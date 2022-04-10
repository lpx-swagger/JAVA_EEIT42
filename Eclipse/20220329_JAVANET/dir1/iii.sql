-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 31, 2022 at 04:03 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

CREATE DATABASE iii DEFAULT CHARACTER SET utf8mb4;

USE iii;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iii`
--

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `addr` varchar(256) NOT NULL,
  `tel` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `name`, `addr`, `tel`) VALUES
(1, '湖莓宴餐坊', '苗栗縣大湖鄉富興村八寮彎2-7號4樓', '037-995677'),
(2, '神雕邨複合式茶棧', '苗栗縣三義鄉廣盛村廣聲新城38鄰2巷26號', '037-875858'),
(3, '甘露自然蔬食餐廳', '苗栗縣三義鄉廣盛村中正路 80號 /苗栗縣通霄鎮楓樹里楓樹窩92-2號', '037-877546 '),
(4, '卓也小屋田媽媽', '苗栗縣三義鄉雙潭村崩山下 1-9 號', '(037) 879-198'),
(5, '秘密花園', '苗栗縣西湖鄉金獅村茶亭6號', '037-923029'),
(6, '龍門口活魚餐廳', '苗栗縣南庄鄉獅山村15鄰165號', '037-822829'),
(7, '巧軒餐館', '苗栗縣公館鄉石墻村11鄰223-1號 ', '037-226868'),
(8, '金葉山莊餐飲部', '苗栗縣卓蘭鎮豐田里13鄰185號', '04-25892292'),
(9, '建成有機農場', '台中市北屯區軍功里建成巷16號', '04-22391019   '),
(10, '麻芛糕餅工作坊', '台中市南屯區萬和路一段94號', '04-23899857'),
(11, '議蘆餐廳', '台中市霧峰區中正路734號', '04-23338818'),
(12, '后里傳統米食舖', '台中市后里區仁里村圳尞路67號', '04-25575171'),
(13, '欣燦客家小館', '台中市潭子區興華一路219號', '04-25345178 '),
(14, '石圍牆客家田園小吃', '台中市東勢區茂興里東蘭路196-65 號', '04-25879197'),
(15, '石岡傳統美食小舖', '台中市石岡區九房村豐勢路889-1號', '04-25721490'),
(16, '清水追菜香', '台中市清水區清水里中山路333號2樓', '04-26221188 '),
(17, '劉員外餐點米食', '台中市外埔區六分路280巷8號', '04-26832197 '),
(18, '紫艾烘焙屋', '台中市潭子區南門街121號', ' 手機：0937-229597'),
(19, '蓉貽健康工作坊', '台中市潭子區栗林里中山路三段 275 巷 47 號', '(04) 2535-3748'),
(20, '九個果子', '台中市潭子區東寶村大德一路2段45號', '04-25330351'),
(21, '品佳客家小吃部', '台中市東勢區粵寧里東蘭路34-7號', '04-25870502'),
(22, '東勢阿嬤客家傳統美食', '台中市東勢區東關路民安巷9-1號', '04-25773017'),
(23, '外埔肉粽', '台中市外埔區中山村中山路486號', '04-26834054'),
(24, '森林咖啡屋', '台中市東勢區勢林街6-1號', '04-25872191#727'),
(25, '古早雞傳統米食', '彰化縣芬園鄉彰南路5段451巷36號', '049-2524362'),
(26, '台稉九號體驗館', '彰化縣田中鎮東路里南北街68號', '04-8749211#228'),
(27, '艾馨園', '彰化縣花壇鄉灣東村灣東路239號', '(04)7881318、7874012'),
(28, '陽光水棧', '彰化縣芳苑鄉漁港六路38號', '04-8933323'),
(29, '漢寶G場', '彰化縣芳苑鄉漢寶村芳漢路漢二段129號', '04-8991027'),
(30, '圓夢工坊', '南投縣竹山鎮下橫街38號', '049-2644077#332'),
(31, '耄饕客棧', '南投縣竹山鎮延和里安定巷146號1樓', '049-2657828'),
(32, '京麟廚房', '南投縣名間鄉大坑村大廈巷66-66號', '049-2730637'),
(33, '田媽媽社區餐廳', '南投市軍功里東山路215號', '049-2203318 '),
(34, '田媽媽美食館', '南投縣鹿谷鄉中正路一段231號', '049-2751692'),
(35, '桑園工坊', '南投縣國姓鄉國姓村1鄰成功街282巷26號', ' 手機：0933-181476'),
(36, '仁上風味坊', '南投縣國姓鄉大石村昌榮巷40-1號', ' 手機：0928-912268'),
(37, '伊娜泰雅風味館', '南投縣仁愛鄉南豐村松原巷 80 號', '0953-558112'),
(38, '蛤仔輝漁產料理', '雲林縣台西鄉五港村五港路428號', '05-6984911'),
(39, '火雞森林', '嘉義縣新港鄉宮前村新民路254-300號', '05-3741851'),
(40, '友茶居', '嘉義縣梅山鄉太和樟樹湖1鄰5號', '05-2562307'),
(41, '古道廚娘', '嘉義縣竹崎鄉中和村奮起湖165-2號(奮起湖鐵道旁)', '05-2561645'),
(42, '茶香山味屋', '嘉義縣阿里山鄉茶山村3鄰60號', '05-2513278'),
(43, '田媽媽 QQ 米香屋', '嘉義縣六腳鄉蒜頭村3鄰23號', '05-3805306 '),
(44, '東石采風味', '嘉義縣東石鄉蔦松村22-1號', '05-3796562'),
(45, '柿菓子手作烘焙坊', '嘉義縣番路鄉新福村8鄰10號', '05-2591846'),
(46, '鄉土美食坊-米食餐點、麵食餐點', '高雄市仁武區仁武里中正路137號', '07-3711331'),
(47, '羊咩咩的家', '高雄市路竹區甲北里永華路302之96號', '07-6961317'),
(48, '彌鄉緣美食', '高雄市彌陀區漯底村樂安路2號', '07-6170885'),
(49, '戀戀蚵仔寮', '高雄市梓官區漁港2路32號', '07-6192554'),
(50, '虱想起料理便當烘焙產品', '高雄市彌陀區南寮村漁港一街60號', '07-6177063'),
(51, '深夜食堂', '高雄市鳳山區五甲一路451之4號', '07-7551011'),
(52, '巧婦店', '屏東縣潮州鎮中山路182號', '08-7882011'),
(53, '走馬瀨田媽媽草香餐坊', '台南市大內區二溪村唭子瓦60號 ', '06-5760123#3003、3008'),
(54, '鹽水鎮農會田媽媽農產美食坊', '台南市鹽水區中山路49號', '066521177/066525071'),
(55, 'ㄋㄋ 寶傳統米麵食餐點', '台南市柳營區士林村柳營路2段77號', '06-622-3994'),
(56, '村長庭園咖啡', '台南市東山區高原村高原100-9號', '06-6861885'),
(57, '仙湖農場 (仙湖休閒農場)', '台南市東山區南勢村1鄰賀老寮6-2號', '06-6863635'),
(58, '故鄉情蔬菜醃漬', '台南市官田區官田村59-40號', '06-6900331'),
(59, '台南鴨莊', '台南市官田區渡頭村29鄰三塊厝178-1號', '06-6901101'),
(60, '官豐美食餐廳', '台南市官田區隆田村文化街25號', '06-6901044'),
(61, '菱成粽藝坊', '台南市官田區湖山里烏山頭7-1號', '06-6981921'),
(62, '農特產水果酥烘焙坊', '台南市山上區山上村238號', '06-5783649'),
(63, '采竹鄉美食', '台南市龍崎區崎頂村7鄰新市子223號', '06-5941114'),
(64, '大坑休閒農場', '台南市新化區大坑里82號', '06-5941555 '),
(65, '臺江美食棧', '台南市安南區四草里大眾路360-6號', '06-2842427 '),
(66, '長盈海味屋', '台南市北門區三寮灣慈安里484號', '06-7850577 '),
(67, '阿里港田媽媽', '屏東縣里港鄉春林村中山路24號', '08-7758406'),
(68, '魩之鄉休閒咖啡', '屏東縣枋寮鄉保生村保生路437號', '08-8781324'),
(69, '東港美食園', '屏東縣東港鎮朝安里新生三路175號', '08-8323122'),
(70, '東遊季養生美食餐館', '台東縣卑南鄉溫泉村溫泉路376巷18號', '089-516111'),
(71, '初鹿黃金果班', '台東縣卑南鄉明峰村牧場28鄰6號', '089-572397'),
(72, '田媽媽米香園', '台東縣關山鎮德高里2鄰11號', '089-931473'),
(73, '池農養生美食餐坊', '台東縣池上鄉新興村7鄰85-6號', '089-862203#36'),
(74, '正一茶園餐坊', '台東縣鹿野鄉永安村7鄰永安路588號', '089-551818 '),
(75, '旗魚咖啡', '台東縣成功鎮大同路65-1號', '089-854899 '),
(76, '台11線花田料理餐館', '台東縣成功鎮忠孝里美山路139號', '089-871848'),
(77, '青山農場', '台東縣太麻里鄉大王村佳崙196號', '089-781677 '),
(78, '達基力部落屋', '花蓮縣秀林鄉崇德村7鄰96號', '03-8621033 '),
(79, '貞饌美食坊', '花蓮縣新城鄉北埔村26鄰北埔路343號', '03-8268698'),
(80, '田園健康補給站', '花蓮縣壽豐鄉豐坪路2段5號', '03-8655111 '),
(81, '富里養生餐坊', '花蓮縣富里鄉羅山村9鄰7號', '03-8821873'),
(82, '富麗禾風', '花蓮縣富里鄉羅山村9鄰6號', '03-8821991'),
(83, '魚鮮上岸', '花蓮縣花蓮市港濱路37號', '03-8222968'),
(84, '米那度海吧餐廳', '花蓮縣豐濱鄉石梯灣港口村76-1號', '03-8781168'),
(85, '星月灣海田料理餐廳', '澎湖縣西嶼鄉大池村131號', '06-9984159 '),
(86, '元貝漁場料理舫', '澎湖縣白沙鄉歧頭村20-2號', '06-9932305 '),
(87, '鮮豐食堂', '金門縣金沙鎮國中路7號', '082-351633 '),
(88, '泰雅風味館', '宜蘭縣大同鄉松羅村玉蘭巷2號', '03-9801903'),
(89, '夢田食堂(五結鄉農會夢田觀光米廠)', '宜蘭縣五結鄉孝威村孝威路402號', '03-9506391'),
(90, '菇鍋美食體驗館', '宜蘭縣冬山鄉永興路二段46-1號', '03-9581157'),
(91, '花之泉生活坊', '宜蘭縣員山鄉尚德村八甲路15-1號', '03-9221506'),
(92, '金益田園美食坊', '宜蘭縣壯圍鄉新南村霧罕路3號', '03-9253517'),
(93, '田園香美食坊', '宜蘭縣頭城鎮中崙里三和路363號2樓', '03-9774778'),
(94, '一佳村養生餐廳', '宜蘭縣冬山鄉中山村中城二路 58 巷 11 號', '03-958-8852'),
(95, '茶之鄉', '宜蘭縣大同鄉泰雅路二段28號', '03-9801118'),
(96, '玉露茶驛站', '宜蘭縣大同鄉松羅村鹿場路10-2號', '03-9801111'),
(97, '山舍茶園', '宜蘭縣大同鄉松羅村鹿場路10號', '039-802168'),
(98, '蔥蒜美食館', '宜蘭縣三星鄉義德村中山路31號', '03-9895179'),
(99, '北海驛站石農肉粽', '新北市石門區石門村中央路2號', '02-26381005'),
(100, '神仙的窩', '新北市瑞芳區龍潭里逢甲路39號', '02-24965363'),
(101, '快樂農家米食坊', '新北市坪林區坪林村水柳118-3號', '02-26656041'),
(102, '千戶傳奇', '新北市三峽區有木里有木154-3 號', '02-26720748 '),
(103, '海景咖啡簡餐', '新北市貢寮區福隆村東興街6-19號', '02-24992073 '),
(104, '桃仔園烘焙坊', '桃園市桃園區新生路165號', '03-3365303'),
(105, '巧婦米食烘焙點心坊', '桃園市平鎮區南東路2號', ''),
(106, '寶聰牧場點心坊', '桃園市大園區五權村15鄰中正東路2段24號', '03-3818015'),
(107, '耀輝米食點心坊', '桃園市楊梅區瑞原里12鄰91-4號', '03-4758049'),
(108, '新屋庄米點烘焙坊', '桃園市新屋區中華路242號', '03-4772124#503'),
(109, '飛鳳傳情米點坊', '新竹縣芎林鄉文林村文昌街120號', '03-5921173#32'),
(110, '新埔鎮農會特有餐飲美食坊', '新竹縣新埔鎮四座里楊新路一段 322 號', '03-5891658'),
(111, '月嵋莊', '新竹縣峨眉鄉峨眉村10鄰88號', '0936-031715'),
(112, '海岸風情', '新竹市北區南寮街 195 號', '03-5364805'),
(113, '八五山泉養殖場', '新竹縣尖石鄉新樂村8鄰36-2號', '03-5842560'),
(114, '烘焙西點米食坊', '苗栗市玉清里11鄰復興路四段197號', '037-279502'),
(115, '牛奶故鄉餐坊', '苗栗縣造橋鄉豐湖村5鄰上山下2號', '037-561126'),
(116, '大坡塘客家農莊', '苗栗縣獅潭鄉豐林村1鄰3-1號', '037-932862'),
(117, '仙山美食小棧', '苗栗縣獅潭鄉新店村小東勢24-1號', '037-932008'),
(118, '雲也居一 (雲也居一休閒農場)', '苗栗縣大湖鄉栗林村 9 鄰薑麻園 6 號', '037-951530'),
(119, '石門客棧', '苗栗縣大湖鄉栗林村16鄰竹橋20號', '037-951129'),
(120, '葉山藥園休閒農場', '基隆市七堵區瑪陵坑大成街43號', '02-24565075(葉金印)'),
(121, '北新休閒農場', '新北市淡水區忠寮里演戲埔腳 3-2 號', '02-26231428'),
(122, '準休閒農場', '新北市五股區新五路二段 70 號', '02-22922466'),
(123, '蕃婆林休閒農場', '新北市三芝區錫板里17鄰蕃婆林44號', '02-26362716、0921-070169'),
(124, '頭城休閒農場', '宜蘭縣頭城鎮更新路 125 號', '03-9772222'),
(125, '花泉休閒農場 ', '宜蘭縣員山鄉尚德村八甲路15-1號', '03-9221506(楊六科)'),
(126, '蓮荷園休閒農場', '桃園市觀音區藍埔里11鄰金華路690號', '03-4871683、03-4776972'),
(127, '好時節休閒農場', '桃園市大溪區康莊路三段225號', '03-3889689'),
(128, '飛牛牧場休閒農場', '苗栗縣通霄鎮南和里166號', '037-782999'),
(129, '雲也居一休閒農場', '苗栗縣大湖鄉栗林村薑麻園9鄰6號', '037-951530'),
(130, '森十八休閒農場', '南投縣名間鄉田仔村田仔巷16-8號', '049-2273797'),
(131, '獨角仙休閒農場', '嘉義縣中埔鄉石硦村 15 鄰石硦 45-2 號', '(05) 203-0666、(05) 253-5336'),
(132, '南元休閒農場', '台南市柳營區果毅里南湖25號', '06-6990726'),
(133, '大坑休閒農場', '台南市新化區大坑里82號 ', '06-5941555'),
(134, '仙湖休閒農場', '台南市東山區南勢里賀老寮一鄰6-2號', '06-6863635'),
(135, '走馬瀨休閒農場', '台南市大內區二溪里唭子瓦 60 號', '06-5760121~3'),
(136, '吉園休閒農場', '台南市麻豆區南勢里總爺104-1號', '06-5725715、06-5727689(梁茂隆)'),
(137, '春園休閒農場', '台南市七股區看坪村看坪46-10號', '06-7895588(林朝明)'),
(138, '鶉園休閒農場', '屏東縣萬巒鄉萬金村營區路 1 巷 8 號', '(08) 783-4236'),
(139, '東遊季養生美食餐館', '台東縣卑南鄉溫泉村溫泉路376巷18號', '089-516111 #700、089-516111 #801(謝小姐、黃先生)');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(10) UNSIGNED NOT NULL,
  `account` varchar(100) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  `realname` varchar(100) NOT NULL,
  `icon` blob,
  `student` blob,
  `money` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `account`, `passwd`, `realname`, `icon`, `student`, `money`) VALUES
(1, 'brad', '$2a$10$NnvF2UVGjRPbKQ7La1yoqOFGbyqcN.nXyek7Q/R1K/OuhaC4H0Gz.', '趙令文', NULL, NULL, 110),
(2, 'peter', '$2a$10$zv81ESXfl8mozSQY3IGrxel.L2jn7NGosLXn7a.Fos6zNPnVHkple', '趙令文', NULL, NULL, 180),
(3, 'kevin', '$2a$10$p5436IxYdyF/np3vMlnA7e0q8KTKDVcnxRVBzwkRv/podS0kD/EbC', '趙令文', NULL, NULL, 0),
(4, 'mary', '$2a$10$QRMEh7aMzyxWOOfZqpxzLuEx3eo/7tJVQk1o4j1vsGGuo7KvJmhuO', '趙令文', NULL, NULL, 0),
(16, 'test', '$2a$10$TtO1f78kHcoHIImrmSRpbuz0pAapu6pVWwel/E.l9OwXvtIVmrDqW', '趙令文', 0x89504e470d0a1a0a0000000d4948445200000040000000400806000000aa6971de000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000ec300000ec301c76fa86400001a1149444154785eb55a099454d599fe5fd57bb534bdd33412911014d01814451d77451ce7b81d132771e2681cb39b3d99389378ce64d19c89f14c8c66512627c638214a144538d1282e13090a8a1007891803429446b6a6e9adaaab5ed5ab37dff7df775fbd2eba8133cbdff5d75ddfbdfff7fffffdefbdafda1111322904db3ca9b1dc48c9f683f51dabed50631f8afecf9eb7838c35d8e14ec27ea483f5fddf0a4c3a9c790e464919ec58071dacb1cd0e901464cc41238aebefbcf34ea7adb92d974ea73b52a9749be34847580bf3415073c3a026412da8d6c2b05829977b835a6dc0cb79fb6ff8ec0d553e0b1e4b0e4bc9b6f1fa8ed5c78e01510eec60c9d6c79da3f48041c0a3ea962f5bee0c0e0e65db5bdb2697cbfe7998e512d775673be24c731c272f61980fc350005a6a5040b55a952008a452a9967dbf5cf0fdca9672b9fcb2effbcf4c3ea27be5da756b07eefef7bbed7c243bdfff8492e38c52806d6804949c68ac8947d53df1c0e92755f35fbad4cb762e00e8133cd76b87e59d540af0d1939d157cad66981ea01c4011155546a55211280e5c92c27071a8ec975f1a2916ffa3ada3edd12ffee3178b66a63165218d574f625b92c654008975c9816c5b72e0b8ff92fb3e946e71379defc8f08d19cf5f909fb2d073734709804b4aa7406780b6560f013c0c8c128200d6d794caa012ac22e8111581174011658102a08ce1770a85c23d9d133b7ffc85af7eb157073674300c494ad669de3e484ae647754aa4966cdff0e907e7cd4d87fd37e7b295f372b9745bc6ab49aaeb2e71bc63e287081c5f006ec02b70a621b81a79412d50655491675c181e29cbdbbdc3f2a71d83b265d7a0ece92fca0814910b7d49570b7b2aa5d26d939b733f7f6ad98f075492844c51da58261d50c78af11e6c24b6b34dfb3d71ff69cd88555fce66fc2f34e5d3ddd96c4adcb423a9141a5b6f12c9cd375d2d70a401005b25840a18eb9f8a80e5e9115c06afef1890275fdd236bb7f5c9be42594ae50ac608049d9054f11cca155f42bf28b94a716b77e8ff7377fbc8a32fadfa8d95dfca391e25713869d63093605272109bb765e7c5df2e98e9a5b6ffb0b9a9f699b616af25df94968ce788eba6e0f6606f92a4f3a743192949711970fd239fc67248711894b9fab83cf8073dc81f7b8664e173dbe5176b76cac69d0519f6a91cce66a765d63c87c1f071a59a4a750cf9950f160b8e7be1fc8bd7bcb1690db413cb49b92d8d5547d2d16d23a9f1210b5eebef5b785d7ae6bb369e9292fdf7b536a78fcde7d3004dab1b30ecaa427ac78b74fe90c687e5e8f2d6fad603b0ce91a7bbefea1b91bb9f7d4b9ef953af94e101eccf7eb1d56bb4bac93bea05b60e581130c36a49c42f485369f8a933674fb976c5f29f24634352fe03f090583814c50fac5a7adc6559afb8b8bdcd6bc67a8f5cde5857f1a32bff42a74964d2a35080abaecf351d72bd1334c1a15cae04f2d0cbefc8f7576c431d9708ea0950539b3780a90c4d01dc28858c7c102921a01246243db4ffcf73a6769db37ee5cff7501a152801762c6287c35102c09f784553ae7f71477b2697cd44968702687155029c9ba4b385106ee262a9a5a6aa0208dc58df28e1f55dc3f2ada59b65c38e2174261802369e81af0878cd589cf908b4200650015621ea055a1729a13c2299e2e0d613a6759ff7d2333fdd415122b29627251582c564c856324de6e5ca2baf90950f4fbb7442be7f6147473697cfb99261c0f352e2617d7b2e3d216dd6bea65cf39e38c1661dc48c480b13aa23cb36ec93ebefdd241b778f2002d1730cab0b318222a5321d8d132c27fb44aced48530861981f938233587a59f1f32d3336beb567c59cb33ed619cd4e4a1a99f9b89c0c82c9cecc6bfacb3b3a8eceba855f75b467a735e5013a0346b07311842ce0340449010c3d017ba0a4db6f12b7e96c49bb390d82aeb6a5e48d9dc372e3923fcb7005168fa6e177fd84c402c914a83436198a324cf421a6a61f3f8eeee8541056454a26958b23c79d72f6c5cbdffed3b8819174c02e9024e7b987664fc9ba833fc69a3fa389915ec14716471a5b1dc0d30018ba33c4edfc8678b939088a380fa4f21a1c09b7500ea4634246103ae4f9ad036a7043911246c9863a2d4209b6ac29885a21472db6def664059f45409d3d3250281ff59ea39eefedd91c351e48f427527dc43a85f9bc7cae798273790c9ed6745dc304aed6a5325ca8320bf05f152f3f13656e8559a324b495b854e16cd55a4aae3cf54869410ca10bd32b4c008d5c9b5a4930e38bb2c28c986d784699f653b6e3605c965d2c412f23fdd5f0ebb5f4d4b315cd3844057064526216715e58366b7e53bef2d9e666cfc92a78b8bd8bb1dd262cb72992cecd9274d3e9e24cb8409ce68b449aaf46f92474306bd1f15a248507c8d9aca7dee24059b98c2b6d79cf80578036354099c66231afe5449efd59d63a2a81cf1b858450bcc6058d0d19093cafe9adbec2cfe65ffded56f3807292e225902467c5d2eb53add9ad77b7b5a4df976fca49a6e958715bdf2f6efb27b1be3f23a9d6ab01fc03224d17e3c4b740247bbe38d9535418cc0cf6388cca4b4371d964209c87a5c273c09a6dfdb2bf880b0f6301fc0eb5e80f8e82a52153d65ce4f20edb996251192598fa300a14a68ec49d0475dc59d2e9ce6aa9d29ff57b56e32e11b5d7a9512b3ad28bbf39e1aad6e6cae2cec9e7a4725d1fc39a3e065ed5aa2ecfe8ac380f4598dc8c8c2f7c747bc7decf8b4d05179dbe822f7fdcde2fafbc35206b36ef938d3d033254f2d191db26f77c6e73dc3a4daa5ba272743022406e878c3028b39dcf85b848e956c96d1197297416b75adb75cde567cdbaf75f3fc17d9752198d81e801a32a5e7be15a4f82be1fb41ff5cda3735d1f8737bf0be0f326d8d18d0f07bc128665f4d3acf1065280f32d778b1c3c626abb27271fd52a57cced92abe64d96138f6c86ff84b26700b73f1c85ad58b4bc66a9c5585292098ed1d0207a501430b5af11a0964e37efd9de9b1edcbef659b668a521158b1c57befcccc7cf9f30f1aa673b27cf4de5110519f03c8f6b18d61f6bc11c8a383266508f04787aabefe3ba0beb54708a636aafc0e64a5c550f79e52ffb65d9fa5df2dc1bbd32880b91436f880e4504664f8eaa653d48a10d07b0504f863c1c55902f9b36c4146cc83b3e7ce9a933eebdf9a370b33a590f50a531fdf4e7eefa645be78c732d7832c1f3d417f71a8b38f1c285225bb78a336306a3a5997cef5ec4891c94c78b113581be581ebc0a331ee82911da314765d69bbaee968c9c3bab5dde7f52b7cc9bda8ceb7049dee907205a590731ecd8b3804dc9d436db220f60900c42a7b534505cbf77f3aa37b432220b9e4f382b9f5be9b5b775ac9d3469d2894d4d4d6a79ab84835a9f00962e15e7914754110abea545646858c2e141915bbf27cef1b820912053b5ccb73e3e5f81695a856754e801ea09f00ab0be1c51461eb183ebfdb59e417962c36e59b169af14d197750c887a94d62335e6c633358cabf706780015abc774c795e674eab16b2f9f77c55d375d6b34835abba2d5b629277d6a369b3d5601ebbae5399fdb8cf61997c275ebc459b60cc0a1a5a609824383c8c8085bb01d6645d6ac311d49184b8fb93a657de0f1a6b0919d57e3a32737c9e7174c937b3ef25ef9f0dc6ec9b2092740231fbfc09a30356c9ee7770a872359f0e2ab3d3c225b0aa9005a9f14e672b9bfca6432595def7c38621d631c0af7ed1379e841d3279b13c1d2916658bfbd5da4ab4b64ca11e2bcf9a6e96c8963aa12b410a575d2399384226bc801bcad638227d79d75a4dc77fd1cb9e4b84ec970afb544994d46f39ab21df98ae3e40bc3fe5c53a9a41ec042f8fb95ab803b7d7ad2fa0708d2485c638b1689f3d6dbb03ef67e2c19c94309ad5000c14f9e0c054c8157e07abc7f7ff41065813dc854423445b46ca33c3251d9e6cdba67773ec093432813b269f9c43953e5964b67c86947b660cda38ddde2614d5fed4f3cb8bff40d954f4385190c69ec01083c4d50c0bca4f50f45e18b2fe1d4b422d2302ab8f6e9016d6d229df0342a6152b74877b784492f605f3d4f98791424c882ac53a2cc2cd8746586a9291fd33d41be7ae174f9a70bde2d79c88f414d23edabf88d0770ce3095e2bbba98ac0730384d04f8495cf38743e110ce1477dc6106d697159084cf22e2cb04c481e66628a14364ea9122b36659c9635205838db2d96c40d52d6e3849a6dc586b8820e6e24cf1a30fce9693a73447bdcc1c4ccd7c29dc4bc2195fbbeb09b8a4523d087a196f2ac0375bcbc75641da20bb01fcb39f89b3bdc7447d465d9ec0480c845c0a74fbee2344de3d5d04dba233199ec0e774f848bcc8038c90acb513218d14c1d4ca6205894a4afa7894674bd64bc997e109571e3f097b3c5aa2f54f0eb195f98ed3b96ee376ac51f30015a0e3a1cb442840c71a0d1ef9e48ca070cb1671962c81d501c8c7b9a2cc5752bcf271fb41674e4805d003ba2662643097039545e22c3a13bb461952345fccfce3f45139a6281bd731899449e61e77e98993e40604ca66ee48b07308661b8d3c3438c29d4027b61e1062cf9dadc244933572ac041f8791db6f17191830a0cb5400ea4a7c25853ccfdf5044a8f100cb814b4219b1210936223b2ce7d01f4da2b9eaf3da1e893a74b0d580ac637064e609c8d43972c291adf2a5f3a6e112865af5849454713fed192c41184356017c9e6f3075603b91322c6a2e25a663b8e9759155ab0cd00a80d3fadcf3478a22c58847e8115006dfebc510417a49012b99f14d6a4e85a3e6d52ea3eba2aa88a20c13d52bbef061b46746df52e3f39eae66b9e9a21992a2b3a38e9e90c9e7703831031885715c1540333a1941d75f664647569ec86eb9451c5e2be9ceeafe500215305cc0c90f817110273f7887b3af57b7be701075aa14f42914511ed463308fbd9c87e3d602e6edbca6fe807cc491dc515e730a805feae2c898c8467737afea8e99dc2c9f3f771aea8c17703af38451808e84ab645585b19332051b6179cc8480afbc22b21aa73a80c79a8102a004ebfe0528a0bf5fa4af4f641f78c73b7a2f90b7714678e71d0977ee94b0a7476a1b3702b0512e99c75f1e7badfb53117a4f88cb49267003dec28f70986f5a9db100b0e8017c4d675fdb9d3373a2cc39a285ef2fc3917200a10da9ae40e8ee6ce36f7356b058c08855e85f2f8617708dc3b519f57507601ca017c0ca54c05e587ecf6e28003bc46baf49b87ebd1e95c3f5eb2458bb566a2b9e9260d7aef8dccf546f8156c9b101924a88409b8c91d86a80c8099c0822d6d7f448cd7b4b7b994bcb67ce9f2e79d72dbfa7b3151633235805844110ec5481280804d25f7260190aa24ad8bd5382471e8e1462aca65b9fc60270094ac0d208e1fa2100d660f560db36a96dd82055784df0fb5512ac5e2dd5d7fe28c1934f2af82a82282f44663c828e00db34e6ba3254584d78db036e326d6ec1c74aa0e579918312b014a8841938301dd3dd3ce4a542ac53a3bad80370ebeac1bd7c58dd1120cd2fb6265585ac785202b8b72a007df4f77c3295060504880701825f30d02fd5ddbba5dab34302b87c75fb762862ab54b76c962a9644158aa93cfcb054100f2ab8e7077c1ee350d13aaf2e81fa8e506748c994d26a0149647d02261403de6c7704ec7af5eb3c992f4c2f3cbab3bf6d722bdf0ce988540087094be5f2fe8aefef53cba81700a40a65d667edb1c734a5b5ccef7a8179a141661e4af2a1880a945041a0abecdd2315827d7bbb547057f091fa2897e11d65c4011f37445a9fcf12780c54630fca0d5e802f237194f28b677f8255a6dbc3ea747f5a9fe0f92ed282b77cf2ecaed7befcb727f3e52071c74b405e7c69cd70b95c7e9dff94402f304b81560658ace7e0a517f526a6ac0a309e6095414baa32080acba13a5c141f31c1c792f07bf74a85293cc8a7720ac352fded63baccac87d998635983615c361ea14a600a325627e313ad797a400a1e40abf35d86874310f3dc0ddc28164c69cedcff37a7ce545d721c2a8019e7d6efdd0a4faeac80179800a50023e156bf2001d6775d016677b0cad0dff9a904551899ca807be36054c50e51298d888f6dd0e70b51ac7b5d424f3d29359c2162d7b78c710932de8dc0044eb6e023d90dfe4811b4ba7a0040123caef548a180345fea98df33a088223c635d3c00280e82fc8200cf944ae51adfced4a8845a14a0feb01e8221f89391a942902af2fc55978aaa40707a022d1ab3ad23ab72008e1cb5d77046a83dfd54049a809182e9fa9ab28fd6594558a9f90d8bdb3fae7dba3d94c02d8f60bd6c46b2d92c9600412318e21a4c0f00ffa1ec9777e90086ea41905c2814b78e1447b63038e9aba82a40c072c1abaff285930aafc282353ec46593d73a70c0fff6608a53b951887906b00c6b190a7f68b1d420783d00a23e026cc0e3f8893c31a336ceabb078ceae7dba3d2dcfa84fb7cfe2e89d8102e8f2540e15c136f47bf6de5fdf139f01401a0435c3af47962d29178bc54525b8a6ae6770501c912a0e31b1fba3ab02466a801138011ba65728f0a89d5e431c06b401888fc9bfba41770d7a08c11a4598bc962995f6e56caa02255a9e6eafe0b9fed5cab03e00137c1e77904cc65305a510f95d17cb209d2e4011bff8e5fd8ba2510d5101d61de481c58b215feddec270a1e0475e100c42c0be7d6a51babe5d020a18a9e6216095acc08dc5d5cd152c18f38d5248d4ceedb3b6f857462111e83a7854827547a0bc91c8f19a570570cba3f5cd692f03d727f86c36a7f59842cf00dc11e0218f2f5aba08c752e34096ad07580a973cba6467a15078bc84c055c151b7da877d1d374063790231001570c4da16b5d73d8231c3823675b132b41ff3b8bafef671a9e1aed0a800349a7840e4048ffe466a82a7e4c821a507a8f5013207eb93190bb82bb1afbed94ebb4528eee7b7ffe8761d29c95400331c9ba92c5ab40807bae1dbe005c33e805710c5758b436b055d98c680c904084163ef48babb6dc733684a2884f8f485b6d4766cc7527825011e8dfc300fc5690064058880ccda87d8f402f500936ae48fd6bdfee802e3d1faac47f45f8a60fe9f3a48038d8a01202a4276eedef90af03f584400aca0a6826a5c7f0c08a404402658cdc76d0416012747edaa04ed13b16d07901a04ae3d8d5326fbf001a41c8cfd9003e31b1f8237d28198d5bc51084113a8b17c20a562590f49dc0611fc7ab15cee3965febce86d8c8e623956405c010abf72e357c272d9ffeee0c0604f0901a4823555811038f11b0fa0b0046099a0c8f8b3ca5105a1ad6e753e132909c003582780fb02b2042b9fc3dd6187ba3cc1ebd6cb91e10106bca1d803740d30cf25600e3e540277ad22aee5dcc574db73dd00f5f70e9786574543903062cc7110d442442c3b575df3a1ad50c0bf0c85186fe244802178e3ea540415528596eb6cca0a3cea671565810790b806c1083cc02cea3574f56241c2a54bd4dd099ecfe97648461e9f3ae1b964d19ef078ce20f852b12469447ee311e94d387b7cffccbf3e837a2629369335a98d01a4e4b8269f92c5fb4be5870a474c91326a14389e3360c1e8368a21a9c94780134c0f51cf40bb299bbc1e8ed867e5efa48663320f4f1af995d189e823c6b7b2cdd8d31fffcbb48cedba3ce2c3f509deb83ebce5d34f3cfb84fdbf410b9c4fdbfca82540d2f1412c3b7f7fddd59572d5ffdcfe93e6fd57114d460975c004a29e0156508da9828e184332c8d91720669b343b08fb06b82b041b100cf5d4c83e46091a18f13c4ad001bea908b039e1e18607997cdc3dfc928ffe828390fe9e5941fbbff5eeddbbeeeb377f0da32b119bc517e7934150416b2941d77fec230385ae497fb7afb965884af031b98fdef565600026dd3e4ed187c0e36581e7e3f341044cc1835569f72c54cfd02b794211a30e4760bdf44001ec5cc6edb30c05107c0696f75caf02d7ff663693b973fefbe75304521297c5a96c7ff3b51da80812cb717ef9f32bf75d76dc7b5fc08deeea54ade6da46720d050aaf8c1810e7136cfb5a1ee525511db7c500bb4e78c25ca9b575c496ae333a81b8deb9eef9206f9efa0f178e2bd94c562f40b0fe0f7cdfbf75ced97392475e8bcf528c8f0ab005a696a3e9eaf9e5bb77bd75f9fbdef772b9afef034ead96611d1b0c1be0264f771d0d9c790bb6316fca91e2e8e27b764bedecf38ce515385a380888e0c9ac22787a12959121782f5345db6d58f7df38e9bcb9be7942e54f52b2ac79ab00d2018d511ae797eddefde645d3a7afc5e1e8fcb05a6d8bea47816964826d046c1816071f50bf778fd4e6ce935a6b6becf2f4009ef6e8f67c7546e5703bccb819058f88df8fb6af8d8c8cfce4940be6f17d1fe950b854adc925c08a646752f2014d1fdfbf7feb85d3a7ffa65ca9cca8f9fe2c56262d7d681e0dda2ac72a4acb8303523bf914b53027d6ff42e56ac512b3071f5def74f9b4bb0175379446461e39ebe233e3979d096ac4348a9241b091ec83169fede37c61cb9637a77dea5357f61d31e5dbfb3cafc0176cfc77082e3afa9ed92eeb6c770ac326381e94fff0b204fcdd11962760277a73470fe0a1879677d3de085a7e893ed7dcf1d31f3c75d6256771aa461a0b3ceb6c3d468f32513a1e113cfbd894a4f98527ce9d5dfdcbb6efb803031f9c800afe8720ddca6a36495683b438f3e4b1f22477f67bc5bbe916f1202241bbb078862f39d3de30cef6dbb0057e177bc3d2732f399bc0f958523e3b0c2929afa5b88f6d2425f3b673e360a403eaeeb9eeba5461f5ea53c3c1c16fa77b7b2fcc61a7482a22f940326d64129f418c37c03f7fa3b8679eab0a00605c1bdce7534eeaee5c3ebbfc8c8bceb06b9d34969ca4f1ea63628764279b4fa6a4c6bab15279f05bdf4aed7bfae9d985cd9b3f9e2e952e4b0d0fcfcc84218e2b461149afd00722623dfb58f0642db7b44aeaeb37f7a6661ebb1441f07e2f975973c165f1de4eb2f327a95136d2b8fd9295c9ce8d64074c5263dda8f2774e3dcd9d94cb9edcbf75eb02b7589c2fc5e2f1e9306c4d05c104b01e4092ecd2e29e574e07c1603a9bdd9dce6436e5bbba1ecbcf9cf9bb6d575cb3eb1f6eb896f15185065b1aab4c4ad625a9b1ff981d59170339081d6e3fa5c73e7a7d4bff9b5bdb0a3ddbbb264c9c38390c6a5da97239eba6d3352f971b08fafaf620ed07f8deaed9b30b673cf040217ad4d201c283c6ab238dd737d96ef331b1b2f1414bc97a9b6fac6b7c3659974c0f553f569b4d934c3adcb6644a4ae66362e5213bfd3fd258f31d6e1de9507d1bda45fe1bd4495e738ed998030000000049454e44ae426082, 0xaced00057372001774772e627261642e6d79636c6173732e53747564656e74460355259bf531270200054900026368490003656e674900046d6174684c000462696b657400164c74772f627261642f6d79636c6173732f42696b653b4c00046e616d657400124c6a6176612f6c616e672f537472696e673b7870000000460000002b000000387372001474772e627261642e6d79636c6173732e42696b65c9c1cd31af70ab3e020001440005737065656478703ff70a3d70a3d70a74000462726164, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
