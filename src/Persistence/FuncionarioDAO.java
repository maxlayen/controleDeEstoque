package Persistence;

/**
 *
 * @author maxna
 */
import Models.Funcionario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FuncionarioDAO {

    private static final String ARQUIVO_DE_FUNCIONARIOS = "funcionario.txt";

    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
        gravarArquivo();
    }

    public ArrayList<Funcionario> listarProdutos() {
        return funcionarios;
    }

    public Funcionario procurarFuncionario(String cpfFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf() == cpfFuncionario) {
                return funcionario;
            }
        }

        return null;
    }

    public void atualizarFuncionario(Funcionario f) {
        // Buscar o produto no arraylist
        Funcionario funcionario = procurarFuncionario(f.getLogin());

        funcionario.setNome(f.getNome());
        funcionario.setLogin(f.getLogin());
        funcionario.setPassword(f.getPassword());
        funcionario.setTelefone(f.getTelefone());

        gravarArquivo();
    }

    public void removerFuncionario(Funcionario f) {
        Funcionario funcionario = procurarFuncionario(f.getCpf());
        funcionarios.remove(funcionario);
        gravarArquivo();
    }

    public Funcionario getFuncionarioByLogin(String login) {
       
        for (int i = 0; i < funcionarios.size(); i++) {
            if (login.equals(funcionarios.get(i).getLogin())) {
                return funcionarios.get(i);
            }
        }

        return null;
    }

    private void gravarArquivo() {
        File f = new File(ARQUIVO_DE_FUNCIONARIOS);

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Funcionario c : funcionarios) {
                bw.write(c.getLogin() + ";" + c.getPassword() + ";" + c.getTelefone() + ";" + c.getNome() + ";" + c.getCpf());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        File f = new File(ARQUIVO_DE_FUNCIONARIOS);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                Funcionario funcionario = new Funcionario(dados[0], dados[1], dados[2], dados[3], dados[4]);
                funcionarios.add(funcionario);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
