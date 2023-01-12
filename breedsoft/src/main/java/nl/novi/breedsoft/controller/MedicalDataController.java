package nl.novi.breedsoft.controller;

import jakarta.validation.Valid;
import nl.novi.breedsoft.dto.medicalDataDtos.MedicalDataInputDto;
import nl.novi.breedsoft.dto.medicalDataDtos.MedicalDataOutputDto;
import nl.novi.breedsoft.dto.medicalDataDtos.MedicalDataPatchDto;
import nl.novi.breedsoft.repository.MedicalDataRepository;
import nl.novi.breedsoft.service.MedicalDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static nl.novi.breedsoft.utility.BindingResultErrorUtility.bindingResultError;

@RestController
@RequestMapping("medicaldata")
public class MedicalDataController {
    private final MedicalDataService medicalDataService;
    private final MedicalDataRepository medicalDataRepository;

    public MedicalDataController(MedicalDataService medicalDataService,
                                 MedicalDataRepository medicalDataRepository) {
        this.medicalDataService = medicalDataService;
        this.medicalDataRepository = medicalDataRepository;
    }

    //Get mapping to get all medical data from the database
    @GetMapping("")
    public ResponseEntity<Iterable<MedicalDataOutputDto>> getAllMedicalData() {
        return ResponseEntity.ok(medicalDataService.getAllMedicalData());
    }

    //Get mapping to get all medical data for one dog by dog id from the database
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Iterable<MedicalDataOutputDto>> getMedicalDataById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(medicalDataService.getMedicaLDataByDogId(id));
    }

    //Create new medical data in database
    @PostMapping("")
    public ResponseEntity<Object> createMedicalData(@Valid @RequestBody MedicalDataInputDto medicalDataInputDto, BindingResult br){
        //If there is an error in the binding
        if(br.hasErrors()){
            return bindingResultError(br);
        } else {
            // Medical data is created, return new medical data uri
            Long createdId = medicalDataService.createMedicalData(medicalDataInputDto);

            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/medicaldata/" + createdId).toUriString());
            return ResponseEntity.created(uri).body("Medical data is successfully created!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMedicalData(@PathVariable("id") Long id, @Valid @RequestBody MedicalDataInputDto medicalDataInputDto, BindingResult br){
        //If there is an error in the binding
        if(br.hasErrors()){
            return bindingResultError(br);
        } else {
            return ResponseEntity.ok().body(medicalDataService.updateMedicalData(id, medicalDataInputDto));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchMedicalData(@PathVariable("id") Long id, @Valid @RequestBody MedicalDataPatchDto medicalDataPatchDto, BindingResult br){
        //If there is an error in the binding
        if (br.hasErrors()) {
            return bindingResultError(br);
        } else {
            MedicalDataOutputDto medicalDataOutputDto = medicalDataService.patchMedicalData(id, medicalDataPatchDto);
            return ResponseEntity.ok().body(medicalDataOutputDto);
        }
    }

                                                   @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicalData(@PathVariable("id") Long id){
        medicalDataService.deleteMedicalData(id);
        return ResponseEntity.noContent().build();
    }

}
