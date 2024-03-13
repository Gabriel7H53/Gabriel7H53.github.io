package controle;

import entidade.Motor;
import interfaces.JanelaCadastroMotores;

public class ControladorCadastroMotores {
    
    public ControladorCadastroMotores(){
        new JanelaCadastroMotores(this).setVisible(true);
    }
    public String inserirMotor(Motor motor) {
        if (!Motor.existeMotorMesmosAtributos(motor)) {
            return Motor.inserirMotor(motor);
        } else {
            return "Já existe um motor com os mesmos atributos";
        }
    }
    public String alterarMotor(Motor motor){
        Motor motor1 = Motor.buscarMotor(motor.getSequencial());
        if(motor1 != null) return Motor.alterarMotor(motor);
        else return "Nome de motor não encontrado";
    }
    public String removerMotor(int sequencial){
        Motor motor1 = Motor.buscarMotor(sequencial);
        if(motor1 != null) return Motor.removerMotor(sequencial);
        else return "Nome de motor não cadastrado";
    }
}
