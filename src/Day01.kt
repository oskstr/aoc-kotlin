fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            charArrayOf(line.first { it.isDigit() }, line.last { it.isDigit() })
                .joinToString("")
                .toInt()
        }
    }

    fun part2(input: List<String>): Int {
        val digits = """(\d|one|two|three|four|five|six|seven|eight|nine)"""
        val firstDigit = digits.toRegex()
        val lastDigit = """.*$digits""".toRegex()

        fun String.getDigit(): Int {
            return when {
                this == "one" -> 1
                this == "two" -> 2
                this == "three" -> 3
                this == "four" -> 4
                this == "five" -> 5
                this == "six" -> 6
                this == "seven" -> 7
                this == "eight" -> 8
                this == "nine" -> 9
                else -> this.toInt()
            }
        }

        return input.sumOf { line ->
            10 * (firstDigit.find(line)?.groupValues?.get(1)?.getDigit() ?: 0) +
                    (lastDigit.find(line)?.groupValues?.get(1)?.getDigit() ?: 0)

        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()

    val testInput2 = readInput("Day01_test_2")
    check(part2(testInput2) == 281)

    part2(input).println()
}
