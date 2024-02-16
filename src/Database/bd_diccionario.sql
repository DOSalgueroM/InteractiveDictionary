-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2024 a las 23:53:27
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_diccionario`


--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diccionario`
--

CREATE TABLE `diccionario` (
  `id` int(11) NOT NULL,
  `palabra` varchar(15) NOT NULL,
  `descripcion` text NOT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `diccionario`
--

INSERT INTO `diccionario` (`id`, `palabra`, `descripcion`) VALUES
(1, 'Respect', 'Feeling of consideration and recognition towards someone.'),
(2, 'Sincere', 'Speaking or acting with truthfulness, without pretense or deceit'),
(3, 'Subtle', 'Delicate, faint, or gentle, usually applied to something that is difficult to perceive or understand'),
(4, 'Substantial', 'Important or relevant in terms of quantity, quality, or significance'),
(5, 'Tranquility', 'Calmness or peace in the mind or in the environment'),
(6, 'Elicit', 'To provoke or generate a feeling, a reaction, or a debate'),
(7, 'Suppress', 'To eliminate, make something disappear, or prohibit something'),
(8, 'Sustain', 'To support or substantiate an idea, theory, or argument with evidence or reasons'),
(9, 'Sarcasm', 'A form of irony used to mock or ridicule something or someone'),
(10, 'Sublime', 'Excellent, grand, or of elevated beauty'),
(11, 'Suspect', 'To have an idea or suspicion that something is true or happening'),
(12, 'Fortunate', 'Having good luck or being in a favorable situation'),
(13, 'Beautiful', 'Pleasant to the sight or having an attractive appearance'),
(14, 'Warm', 'Having a pleasant temperature or generating heat'),
(15, 'Amusement', 'Activity or entertainment that brings joy or pleasure'),
(16, 'Charming', 'Having attractive or seductive qualities'),
(17, 'Happiness', 'A state of mood characterized by joy and satisfaction'),
(18, 'Generous', 'Having the disposition to give or share with others'),
(19, 'Honest', 'Acting with rectitude and sincerity in actions'),
(20, 'Intelligent', 'Having the ability to reason, comprehend, or solve problems'),
(21, 'Jubilation', 'Intense joy or overflowing happiness'),
(22, 'Luminous', 'Emitting or reflecting light in a bright or intense manner'),
(23, 'Wonderful', 'Causing astonishment, admiration, or great satisfaction'),
(24, 'Nobility', 'Quality of being noble or generous in feelings and actions'),
(25, 'Opportunity', 'Favorable or suitable moment to accomplish something'),
(26, 'Patient', 'Having the capacity to tolerate or wait with calmness'),
(27, 'Dear', 'Appreciated or esteemed with affection'),
(28, 'Wise', 'Person who possesses profound knowledge and experience'),
(29, 'Tenacious', 'Showing persistence, determination, and resistance'),
(30, 'Unique', 'Being singular, unequalled, or extraordinary'),
(31, 'Brave', 'Showing courage, audacity, and determination'),
(32, 'Xylophone', 'Musical percussion instrument formed by wooden plates'),
(33, 'Yogurt', 'Dairy product obtained by fermenting milk'),
(34, 'Sapphire', 'Precious gemstone of blue color, belonging to the corundum group'),
(35, 'Abundant', 'Existing or found in large quantity or measure'),
(36, 'Beauty', 'Quality or set of characteristics that are pleasing to the senses'),
(37, 'Glowing', 'Being very hot or burning'),
(38, 'Outstanding', 'Standing out or distinguished by some quality or merit'),
(39, 'Energetic', 'Having or showing energy, vitality, and dynamism'),
(40, 'Fascinating', 'Producing great attraction, interest, or admiration'),
(41, 'Genuine', 'Being authentic, true, and inherent to its nature'),
(42, 'Skillful', 'Having skill or dexterity to do something'),
(43, 'Illustrious', 'Famous, distinguished, or renowned'),
(44, 'Jovial', 'Being cheerful, lively, and in good humor'),
(45, 'Kilometer', 'Unit of length equivalent to 1,000 meters'),
(46, 'Luminosity', 'Quality of emitting or reflecting light intensely'),
(47, 'Melody', 'Sequence of sounds perceived as a musical unit'),
(48, 'Nostalgia', 'Feeling of longing or sadness for something or someone from the past'),
(49, 'Occasion', 'Moment or propitious circumstance to do something'),
(50, 'Peaceful', 'Being calm, peaceful, and free from conflicts'),
(51, 'Chimera', 'Illusion or unrealizable fantasy'),
(52, 'Radiant', 'Radiating light, brightness, or happiness'),
(53, 'Serenity', 'State of calm, peace, and tranquility'),
(54, 'Tenderness', 'Feeling of affection and delicate care'),
(55, 'Useful', 'Being suitable or beneficial for a specific purpose'),
(56, 'Valuable', 'Having high value, whether material or emotional'),
(57, 'Windsurf', 'Water sport that combines surfing and sailing'),
(58, 'Xenophobia', 'Aversion, fear, or rejection towards foreigners or foreign things'),
(59, 'Yacht', 'Recreational or luxury boat used for sports navigation'),
(60, 'Zoology', 'Science that studies animals and their behavior'),
(61, 'Friendship', 'Relationship of affection, sympathy, and trust between people'),
(62, 'Benevolence', 'Inclination to do good and help others'),
(63, 'Creativity', 'Faculty of creating, inventing, or producing something new and original'),
(64, 'Dedication', 'Action of giving oneself completely to something or someone'),
(65, 'Empathy', 'Ability to put oneself in the place of another person and understand their feelings'),
(66, 'Strength', 'Quality of being strong, resistant, and brave in the face of adversity'),
(67, 'Gratitude', 'Feeling of thanks and recognition towards someone'),
(68, 'Ability', 'Capacity to perform something with skill and efficiency'),
(69, 'Innovation', 'Action of introducing novelties or improvements to something existing'),
(70, 'Justice', 'Moral principle that establishes giving each one what they deserve'),
(71, 'Loyalty', 'Fidelity and commitment towards someone or something'),
(72, 'Motivation', 'Internal force that drives a person to achieve their goals'),
(73, 'Optimism', 'Positive and hopeful mental attitude'),
(74, 'Patience', 'Capacity to wait with calmness and tolerance'),
(75, 'Resilience', 'Capacity to adapt and overcome difficult situations'),
(76, 'Sincerity', 'Quality of being honest, frank, and truthful in words and actions'),
(77, 'Tolerance', 'Respect and acceptance towards different ideas, beliefs, or behaviors'),
(78, 'Unity', 'Quality of being united and acting together'),
(79, 'Willpower', 'Faculty of deciding and carrying out something consciously');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `diccionario`
--
ALTER TABLE `diccionario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `diccionario`
--
ALTER TABLE `diccionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
