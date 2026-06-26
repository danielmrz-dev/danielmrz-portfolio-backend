package br.com.danielmrz.danielmrz_portfolio_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String image;
  private String repositoryLink;
  private String liveSiteLink;
  private List<Technologies> technologies;


  public Project(
    String name,
    String image,
    String repositoryLink,
    String liveSiteLink,
    List<Technologies> technologies
  ) {
    this.name = name;
    this.image = image;
    this.repositoryLink = repositoryLink;
    this.liveSiteLink = liveSiteLink;
    this.technologies = technologies;
  }

  public Project() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getRepositoryLink() {
    return repositoryLink;
  }

  public void setRepositoryLink(String repositoryLink) {
    this.repositoryLink = repositoryLink;
  }

  public String getLiveSiteLink() {
    return liveSiteLink;
  }

  public void setLiveSiteLink(String liveSiteLink) {
    this.liveSiteLink = liveSiteLink;
  }

  public List<Technologies> getTechnologies() {
    return technologies;
  }

  public void setTechnologies(List<Technologies> technologies) {
    this.technologies = technologies;
  }
}
