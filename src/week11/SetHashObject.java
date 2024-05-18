package week11;

public class SetHashObject {
    Object[] sethash;

    SetHashObject(){
        sethash = new Object[0];
    }

    public void add(Object o){
        Object[] new_sethash = new Object[sethash.length+1];
        System.arraycopy(sethash,0, new_sethash, 0, sethash.length);
        new_sethash[sethash.length] = o;
        sethash = new_sethash;
    }

    public boolean contains(Object o){
        if(o == null) return false;
        for (Object object : sethash) {
            if (object.equals(o)) return true;
        }
        return false;
    }

    public void remove(Object o){
        if(!contains(o)) return;

        Object[] new_sethash = new Object[sethash.length-1];

        int index=0;
        for (Object object : sethash) {
            if (object.equals(o)) continue;
            else new_sethash[index++] = object;
        }
        sethash = new_sethash;
    }

    public void clear(){
        sethash = new Object[0];
    }

    public int size(){
        return sethash.length;
    }
}
