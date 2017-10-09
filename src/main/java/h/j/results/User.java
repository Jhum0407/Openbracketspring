package h.j.results;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.RestTemplate;


public class User implements Comparable {
    @JsonIgnoreProperties(ignoreUnknown =true)
    private String name;
    private String username;
    private int rank;
    private double score;
    private String email;
    private String country;
    private String city;
    private String school;
    private boolean workInUS;
    private String citizenship;
    private String pro;
    private String graduation;
    private String experience;
    private String resume;
    private String gender;
    private String zipCode;
    private String distance;
    private String status;
   // private Invitation invitation;
    private String linkedIn;

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
/*
    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }


    public void setRank(String srank) {
        rank=Integer.parseInt(srank) ;
    }

    public boolean isWorkInUS() {
        return workInUS;
    }

    public void setWorkInUS(String cworkInUS) {
        if(this.getCountry().equalsIgnoreCase("United States")){
            workInUS=true;
        }
        else {

            workInUS = false;
        }
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(String stscore) {
        score = Double.parseDouble(stscore);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }



    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public double changeDistance(){
        distance=distance.replace(",","");
        return Double.parseDouble(distance.substring(0,distance.length()-3));
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getZipCode() {

        return zipCode;
    }

    public void setZipCode(String zipCode) {

            this.zipCode=zipCode;
        }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


    @Override
    public String toString(){
        return name + " " + username + "\n";
    }


    @Override
    public int compareTo(Object object) {
        User user= (User) object;
        return(int)(this.changeDistance()-user.changeDistance());
    }
}
