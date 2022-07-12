package com.example.ProyectoClinic.modelo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @SequenceGenerator(name="turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "paciente_Id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(Long id, Date date, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.date = date;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Date date, Paciente paciente, Odontologo odontologo) {
        this.date = date;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    @Override
    public String toString() {
        return "Turno" +
                "id=" + id +
                ", date=" + date +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo;
    }
}
