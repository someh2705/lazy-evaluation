package core

fun <T> filter(iterable: Iterable<T>, predicate: (T) -> Boolean): Iterable<T> {
    val iterator = iterable.iterator()
    val new = arrayListOf<T>()

    while (iterator.hasNext()) {
        val element = iterator.next()
        if (predicate(element)) {
            new.add(element)
        }
    }

    return new.asIterable()
}

fun <T> filter(predicate: (T) -> Boolean): (Iterable<T>) -> Iterable<T> {
    return { iterable: Iterable<T> ->
    	filter(iterable, predicate)
    }
}
