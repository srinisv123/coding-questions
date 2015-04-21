//Implement an iterator of iterator

class IteratorIterator<T> implements Iterator<T> {

    Iterator<Iterator<T>> iter;
    Iterator<T> delegate;
    public IteratorIterator(Iterator<Iterator<T>> iterIter) {
        this.iter = iterIter;
        this.delegate = this.iter.next();
    
    }


    public boolean hasNext() {
        if(!this.delegate.hasNext())
            while (this.iter.next() == null);
        }

        return this.iter.hasNext();
    }


    public <T> next() throws NotFoundException{

        if (!this.delegate.hasNext()) {
            throw new NotFoundException();
        }
        return this.delegate.next();

    }


}
