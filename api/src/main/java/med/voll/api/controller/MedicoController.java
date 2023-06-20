package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
@CrossOrigin
public class MedicoController {

    private MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados ){

        var medicos = repository.save(new Medico(dados));
        System.out.println(dados);

    }
}
