package homewor.com.second;

class myException extends Exception{
   private String message;
    public myException(String message){
    this.message=message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
