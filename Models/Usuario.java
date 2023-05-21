package Models;

public class Usuario {
    public String username;
    public String password;

    public Usuario() 
    { }
    
    public Usuario(String username, String password)
    {
    	this.username = username;
    	this.password = password;
    }
    
    // Username Get; Set;
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    // Password Get; Set;
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }
}
