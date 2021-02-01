package xj.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sun.management.Agent;
import xj.students.model.Student;
import xj.students.repositrory.StudentRepository;

import java.sql.Date;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping({"/gestionEtudiants"})
    public String index2(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("numPage",page);
        try {
            Page<Student> studentsPage = this.studentRepository.findAll(PageRequest.of(page, 10));
            int[] pages = new int[studentsPage.getTotalPages()];
            model.addAttribute("studentsPage", studentsPage.getContent());
            model.addAttribute("nombrePage", pages);
        } catch (Exception e) {
            model.addAttribute("exception",e);
            return "gestionEtudiants?error=true";
        }
        return "gestionEtudiants";
    }

    @RequestMapping({"/gestionEtudiants/supprimer"})
    public String supprimerCompte(Model model, int page, String codeMassar) {
        studentRepository.deleteById(codeMassar);
        return "redirect:/gestionEtudiants/?page=" + page + "&s=1";
    }


    @RequestMapping({"/gestionEtudiants/ajouter"})
    public String ajouter(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("numPage", (Object) page);
        try {
            Page<Student> studentsPage = this.studentRepository.findAll(PageRequest.of(page, 10));
            int[] pages = new int[studentsPage.getTotalPages()];
            model.addAttribute("studentsPage", studentsPage.getContent());
            model.addAttribute("nombrePage", pages);
            model.addAttribute("ajouter", (Object) true);
        } catch (Exception e) {
            model.addAttribute("exception", (Object) e);
            return "gestionEtudiants";
        }
        return "gestionEtudiants";
    }

    @RequestMapping(value = {"/gestionEtudiants/ajouterAgent"}, method = {RequestMethod.POST})
    public String ajouterAgent(Model model, String codeMassar, String prenom, String nom,  String email, String date) {
        int page = 0;
        try {
            this.studentRepository.save(new Student(codeMassar, prenom, nom, Date.valueOf(date), email));
        } catch (Exception e) {
            return "redirect:/gestionEtudiants?page=" + page + "&a=0";
        }
        return "redirect:/gestionEtudiants?page=" + page + "&a=1";
    }
/*

    @RequestMapping(value = {"/gestionEtudiants/rechercheAgent"}, method = {RequestMethod.POST})
    public String rechercheAgents(Model model, String par, String input, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("numPage", (Object) page);
        try {
            if (par.equals("code")) {
                Page<Agent> agentPage = this.studentRepository.listAgentsByCode(Integer.valueOf(input), page, 10);
                int[] pages = new int[agentPage.getTotalPages()];
                model.addAttribute("agentPage", (Object) agentPage.getContent());
                model.addAttribute("nombrePage", (Object) pages);
            } else if (par.equals("nom")) {
                Page<Agent> agentPage = this.studentRepository.listAgentsByNom(input, page, 10);
                int[] pages = new int[agentPage.getTotalPages()];
                model.addAttribute("agentPage", (Object) agentPage.getContent());
                model.addAttribute("nombrePage", (Object) pages);
            } else if (par.equals("cin")) {
                Page<Agent> agentPage = this.studentRepository.listAgentsByCin(input, page, 10);
                int[] pages = new int[agentPage.getTotalPages()];
                model.addAttribute("agentPage", (Object) agentPage.getContent());
                model.addAttribute("nombrePage", (Object) pages);
            } else {
                Page<Agent> agentPage = this.studentRepository.listAgents(page, 10);
                int[] pages = new int[agentPage.getTotalPages()];
                model.addAttribute("agentPage", (Object) agentPage.getContent());
                model.addAttribute("nombrePage", (Object) pages);
            }
        } catch (Exception e) {
            return "redirect:/gestionEtudiants?input=false";
        }
        return "gestionEtudiants";
    }

    @RequestMapping({"/gestionEtudiants/rechercheAgent"})
    public String rechercheAgentsGet() {
        return "redirect:/gestionEtudiants";
    }

    @RequestMapping({"/gestionEtudiants/edit"})
    public String editer(Model model, @RequestParam(name = "codeAgent") Integer codeAgent, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("numPage", (Object) page);
        try {
            Page<Agent> agentPage = this.studentRepository.listAgents(page, 10);
            int[] pages = new int[agentPage.getTotalPages()];
            model.addAttribute("agentPage", (Object) agentPage.getContent());
            model.addAttribute("nombrePage", (Object) pages);
            Agent agent = this.studentRepository.consulterAgent(codeAgent);
            model.addAttribute("agentE", (Object) agent);
        } catch (Exception e) {
            model.addAttribute("exception", (Object) e);
            return "gestionEtudiants";
        }
        return "gestionEtudiants";
    }

    @RequestMapping(value = {"/gestionEtudiants/modifier"}, method = {RequestMethod.POST})
    public String modifierAgent(Model model, int page, Integer codeAgent, String cin, String prenom, String nom, String tele, String ville, String email, String date) {
        try {
            this.studentRepository.modifierAgent(codeAgent, cin, prenom, nom, tele, ville, email, date);
        } catch (Exception e) {
            return "redirect:/gestionEtudiants?page=" + page + "&m=0";
        }
        return "redirect:/gestionEtudiants?page=" + page + "&m=1";
    }



    @RequestMapping({"/gestionEtudiants/ajouter"})
    public String ajouter(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("numPage", (Object) page);
        try {
            Page<Agent> agentPage = this.studentRepository.listAgents(page, 10);
            int[] pages = new int[agentPage.getTotalPages()];
            model.addAttribute("agentPage", (Object) agentPage.getContent());
            model.addAttribute("nombrePage", (Object) pages);
            model.addAttribute("ajouter", (Object) true);
        } catch (Exception e) {
            model.addAttribute("exception", (Object) e);
            return "gestionEtudiants";
        }
        return "gestionEtudiants";
    }

    @RequestMapping(value = {"/gestionEtudiants/ajouterAgent"}, method = {RequestMethod.POST})
    public String ajouterAgent(Model model, String cin, String prenom, String nom, String tele, String ville, String email, String date) {
        int page = 0;
        try {
            this.studentRepository.ajouterAgent(new Agent(cin, prenom, nom, tele, ville, email, (java.util.Date) Date.valueOf(date), (Agence) null));
        } catch (Exception e) {
            return "redirect:/gestionEtudiants?page=" + page + "&a=0";
        }
        return "redirect:/gestionEtudiants?page=" + page + "&a=1";
    }*/
}