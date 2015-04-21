//Implement a peek iterator, that along with next and hasNext, has a peek function

import java.util.Iterator;


class PeekIterator<T> implements Iterator<T> {

    Iterator<T> iter;
    boolean peeked;
    T peekedVal;

    public PeekIterator(Iterator<T> itr) {
        this.iter = itr;
        this.peeked = false;
        this.peekedVal = null;
    }

    public boolean hasNext() {
        
        if (this.peeked) {
            return true;
        } else {
            return this.iter.hasNext();
        }
    }



    public T next() {

        if (this.peeked) {
            this.peeked = false;
            return this.peekedVal;
        } else {
            return (T)this.iter.next();
        }


    }



    public T peek() {

        if (this.peeked) {
            return this.peekedVal;
        } else{
            this.peeked=true;
            this.peekedVal =  this.iter.next();
            return this.peekedVal;
        }
    }

    public T remove()





}
