package br.com.projetoam.hospital.resource;

import br.com.projetoam.hospital.model.Especialidade;
import br.com.projetoam.hospital.model.Hospital;
import br.com.projetoam.hospital.repository.EspecialidadeRepository;
import br.com.projetoam.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalResource {
    @Autowired
    private HospitalRepository repository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping("/listar")
    public List<Hospital> listar(){
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Hospital buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }

    @GetMapping("listar/{nome}")
    public List<Hospital> buscarPorEspecialidade(@PathVariable String nome){
        return repository.findByEspecialidades_Nome(nome);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Hospital cadastrar(@RequestBody Hospital hospital){
        List<Especialidade> esp= new ArrayList<>();
        for (Especialidade e: hospital.getEspecialidades()) {
            esp.add(especialidadeRepository.findById(e.getCodigo()).get());
        }
        hospital.setEspecialidades(esp);
        return repository.save(hospital);
    }

    @PutMapping("/atualizar/{id}")
    public Hospital atualizar(@RequestBody Hospital hospital,
                              @PathVariable int id){
        hospital.setCodigo(id);
        return repository.save(hospital);
    }


    @DeleteMapping("/remover/{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }
}
