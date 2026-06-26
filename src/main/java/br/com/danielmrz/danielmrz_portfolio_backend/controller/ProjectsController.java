package br.com.danielmrz.danielmrz_portfolio_backend.controller;

import br.com.danielmrz.danielmrz_portfolio_backend.dto.CreateProjectDTO;
import br.com.danielmrz.danielmrz_portfolio_backend.model.Project;
import br.com.danielmrz.danielmrz_portfolio_backend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjectsController {

  @Autowired
  private ProjectService projectService;

  @GetMapping
  public ResponseEntity<List<Project>> testeProjects() {
    return ResponseEntity.ok(projectService.getAllProjects());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Project> findProjectById(@PathVariable Long id) {
    Project project = projectService.findProjectById(id);
    return ResponseEntity.ok(project);
  }

  @PostMapping()
  public ResponseEntity<Project> saveProject(@RequestBody @Valid CreateProjectDTO newProject) {
    Project project = projectService.saveProject(newProject);
    return ResponseEntity.status(HttpStatus.CREATED).body(project);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Project> editProject(@PathVariable Long id, @RequestBody @Valid CreateProjectDTO updatedProject) {
    Project updated = projectService.updateProject(id, updatedProject);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProject(@PathVariable Long id) {
    projectService.deleteProject(id);
    return ResponseEntity.noContent().build();
  }

}
