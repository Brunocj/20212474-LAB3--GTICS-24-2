package com.example.lab3_gtics_20212474.controller;

import com.example.lab3_gtics_20212474.entity.Employee;
import com.example.lab3_gtics_20212474.entity.JobHistory;
import com.example.lab3_gtics_20212474.repository.JobHistoryRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.lab3_gtics_20212474.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller

public class Lab3Controller {

    final com.example.lab3_gtics_20212474.repository.EmployeeRepository employeeRepository;
    final com.example.lab3_gtics_20212474.repository.JobHistoryRepository jobHistoryRepository;

    public Lab3Controller(EmployeeRepository employeeRepository, JobHistoryRepository jobHistoryRepository) {
        this.employeeRepository = employeeRepository;
        this.jobHistoryRepository = jobHistoryRepository;
    }

    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        ArrayList<Employee> listaFinal = new ArrayList<>();

        for(Employee employee : lista){
            if(employee.getEnabled() == 1){
                listaFinal.add(employee);
            }
        }
        model.addAttribute("employeeList", listaFinal);
        return "empleados";
    }
    @GetMapping("/delete")
    public String borrarEmpleado(Model model, @RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            //Cambiar el valor del enabled del employee a 1
            Employee employee = optEmployee.get();
            employee.setEnabled(0);
        } else {
            redirectAttributes.addFlashAttribute("error", "Empleado no encontrado.");
        }
        return "redirect:/employee/list";
    }
    @GetMapping("employee/edit/{id}")
    public String editEmpleado(@PathVariable("id") Integer employeeId, Model model) {
        Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
        if(optEmployee.isPresent()){
            Employee employee = optEmployee.get();
            model.addAttribute("employee",employee);

        }
        return "editarEmpleado";
    }


    @GetMapping({"reportes"})
    public String reporte() {

        return "reportes";
    }

    @GetMapping({"historial"})
    public String historial(Model model) {
        List<JobHistory> lista = jobHistoryRepository.findAll();
        model.addAttribute("jobhistorylist", lista);
        return "historial";
    }
}
