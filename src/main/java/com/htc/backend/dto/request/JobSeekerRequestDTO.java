package com.htc.backend.dto.request;

public class JobSeekerRequestDTO {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String skills;
    private Integer expYears;
    private String resumeUrl;
    
    // Constructors
    public JobSeekerRequestDTO() {
    }
    
    public JobSeekerRequestDTO(String firstName, String lastName, String email, String password,
                               String address, String skills, Integer expYears, String resumeUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.skills = skills;
        this.expYears = expYears;
        this.resumeUrl = resumeUrl;
    }
    
    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getSkills() {
        return skills;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public Integer getExpYears() {
        return expYears;
    }
    
    public void setExpYears(Integer expYears) {
        this.expYears = expYears;
    }
    
    public String getResumeUrl() {
        return resumeUrl;
    }
    
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
    
    @Override
    public String toString() {
        return "JobSeekerRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", skills='" + skills + '\'' +
                ", expYears=" + expYears +
                ", resumeUrl='" + resumeUrl + '\'' +
                '}';
    }
}
