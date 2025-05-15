class Storage<T> {

    private var allData = mutableMapOf<Int, T>()
    private var nextId = 1

    fun add(item: T): T {
        val id = nextId++
        allData[id] = item
        return item
    }

    fun setAllData(data: MutableMap<Int, T>){
        allData = data
    }

    fun get(id: Int): T? = allData[id]

}