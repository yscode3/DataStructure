class GetRandomNumbers() {
    fun getNumbers(): List<Int> {
        var numbers = ArrayList<Int>()

        while (numbers.size != 10) {
            val num = (1..100).random()
            numbers.add(num)
            numbers.toSet()
        }

        return numbers
    }
}