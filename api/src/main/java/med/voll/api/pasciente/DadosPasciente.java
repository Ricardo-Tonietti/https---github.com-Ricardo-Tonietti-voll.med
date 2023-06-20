package med.voll.api.pasciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosPasciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
