package br.com.danielmrz.danielmrz_portfolio_backend.service;

import br.com.danielmrz.danielmrz_portfolio_backend.dto.CreateProjectDTO;
import br.com.danielmrz.danielmrz_portfolio_backend.exception.ProjectAlreadyExistsException;
import br.com.danielmrz.danielmrz_portfolio_backend.exception.ProjectNotFoundException;
import br.com.danielmrz.danielmrz_portfolio_backend.model.Project;
import br.com.danielmrz.danielmrz_portfolio_backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  public Project saveProject(CreateProjectDTO newProject) {
    List<Project> allProjects = getAllProjects();
    boolean projectAlreadyRegistered = allProjects.stream().anyMatch(p -> p.getName().equalsIgnoreCase(newProject.name()));
    if (projectAlreadyRegistered) {
      throw new ProjectAlreadyExistsException("Um projeto com este nome já foi cadastrado.");
    }
    Project project = new Project(
      newProject.name(),
      newProject.image(),
      newProject.repositoryLink(),
      newProject.liveSiteLink(),
      newProject.technologies()
    );
    return projectRepository.save(project);
  }

  public void deleteProject(Long id) {
    Project project = findProjectById(id);
    projectRepository.deleteById(project.getId());
  }

  public Project findProjectById(Long id) {
    return projectRepository
      .findById(id)
      .orElseThrow(
        () -> new ProjectNotFoundException("O projeto com id: " + id + " não foi encontrado")
      );
  }

  public Project updateProject(Long id, CreateProjectDTO updatedProject) {
    Project projectToUpdate = findProjectById(id);
    projectToUpdate.setName(updatedProject.name());
    projectToUpdate.setImage(updatedProject.image());
    projectToUpdate.setRepositoryLink(updatedProject.repositoryLink());
    projectToUpdate.setLiveSiteLink(updatedProject.liveSiteLink());
    projectToUpdate.setTechnologies(updatedProject.technologies());
    return projectRepository.save(projectToUpdate);
  }
}
