package Models;

/**
 *
 * @author maxna
 */
public class Funcionario extends Pessoa {
    
    private String login;
    private String password;
    private String telefone;

    public Funcionario(String login, String password, String telefone, String nome, String cpf) {
        super(nome, cpf);
        this.login = login;
        this.password = password;
        this.telefone = telefone;
    }
    
    public Funcionario(){
        
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
