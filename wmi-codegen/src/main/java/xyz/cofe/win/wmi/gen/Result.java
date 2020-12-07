package xyz.cofe.win.wmi.gen;

public class Result<T> {
    public Result(){
        this.result = null;
        this.ok = false;
    }

    public Result(T result){
        this.result = result;
        this.ok = true;
    }

    public Result(T result, boolean ok){
        this.result = result;
        this.ok = ok;
    }

    public static <T> Result<T> ok(T result){
        return new Result<>(result);
    }
    public static <T> Result<T> fail(T result){
        return new Result<>(result,false);
    }

    protected T result;
    public T getResult(){ return result; }

    protected boolean ok;
    public boolean isOk(){ return ok; }
}
