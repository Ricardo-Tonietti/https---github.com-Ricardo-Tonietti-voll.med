package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    private final ConsultaRepository repository;

    public ValidadorMedicoComOutraConsultaNoMesmoHorario(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico já possui outr consulta agendada nesse mesmo horario");
        }
    }
}
