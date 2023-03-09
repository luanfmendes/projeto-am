package br.com.projetoam.hospital.resource;

import br.com.projetoam.hospital.model.Especialidade;
import br.com.projetoam.hospital.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeResource {
    @Autowired
    private EspecialidadeRepository repository;

    @GetMapping("/listar")
    public List<Especialidade> listar(){
        return repository.findAll();
    }
    @GetMapping("{codigo}")
    public Especialidade buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Especialidade cadastrar(@RequestBody Especialidade especialidade){

        return repository.save(especialidade);
    }

    @PutMapping("/atualizar/{id}")
    public Especialidade atualizar(@RequestBody Especialidade especialidade,
                                   @PathVariable int id){
        especialidade.setCodigo(id);
        return repository.save(especialidade);
    }

    @DeleteMapping("/remover/{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }
}
