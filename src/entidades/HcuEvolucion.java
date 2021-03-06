/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tools.MyDate_IN_ejb;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "hcu_evolucion")
@NamedQueries({
    @NamedQuery(name = "HcuEvolucion.findAll", query = "SELECT h FROM HcuEvolucion h")})
public class HcuEvolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name="id_info_historiac",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private InfoHistoriac idInfoHistoriac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private Float temperatura;
    @Column(name = "fc")
    private Short fc;
    @Column(name = "sao2")
    private Short sao2;
    @Column(name = "fr")
    private Float fr;
    @Column(name = "tas")
    private Short tas;
    @Column(name = "tad")
    private Short tad;
    @Column(name = "apertura_ocular")
    private Short aperturaOcular;
    @Column(name = "respuesta_verbal")
    private Short respuestaVerbal;
    @Column(name = "respuesta_motora")
    private Short respuestaMotora;
    @Column(name = "conciencia")
    private Short conciencia;
    @Lob
    @Column(name = "otrossignos")
    private String otrossignos;
    @Lob
    @Column(name = "subjetivo")
    private String subjetivo;
    @JoinColumn(name="dx",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticCie10 dx;
    @JoinColumn(name="dx1",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticCie10 dx1;
    @JoinColumn(name="dx2",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticCie10 dx2;
    @JoinColumn(name="dx3",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticCie10 dx3;
    @JoinColumn(name="dx4",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticCie10 dx4;
    @Lob
    @Column(name = "analisis")
    private String analisis;
    @Lob
    @Column(name = "objetivo")
    private String objetivo;
    @Basic(optional = false)
    @Column(name = "fecha_evo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name="id_static_especialidades",referencedColumnName = "id")
    @ManyToOne(optional=false)
    private StaticEspecialidades idStaticEspecialidades;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @Column(name = "usuario")
    private int usuario;
    @Basic(optional = false)
    @Column(name = "f_digita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDigita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoMedidasg> hcuEvoMedidasgs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoInterconsulta> hcuEvoInterconsultas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoPosologia> hcuEvoPosologias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoMezclasMedicamentos> hcuEvoMezclasMedicamentoses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoProcedimiento> hcuEvoProcedimientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHcuEvolucion")
    private List<HcuEvoEgreso> hcuEvoEgreso;

    public HcuEvolucion() {
    }

    public HcuEvolucion(Integer id) {
        this.id = id;
    }

    public HcuEvolucion(Integer id, InfoHistoriac idInfoHistoriac, String otrossignos, String subjetivo, String objetivo, Date fechaEvo, int estado, int usuario, Date fDigita) {
        this.id = id;
        this.idInfoHistoriac = idInfoHistoriac;
        this.otrossignos = otrossignos;
        this.subjetivo = subjetivo;
        this.objetivo = objetivo;
        this.fechaEvo = fechaEvo;
        this.estado = estado;
        this.usuario = usuario;
        this.fDigita = fDigita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InfoHistoriac getIdInfoHistoriac() {
        return idInfoHistoriac;
    }

    public void setIdInfoHistoriac(InfoHistoriac idInfoHistoriac) {
        this.idInfoHistoriac = idInfoHistoriac;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Short getFc() {
        return fc;
    }

    public void setFc(Short fc) {
        this.fc = fc;
    }

    public Short getSao2() {
        return sao2;
    }

    public void setSao2(Short sao2) {
        this.sao2 = sao2;
    }

    public Float getFr() {
        return fr;
    }

    public void setFr(Float fr) {
        this.fr = fr;
    }

    public Short getTas() {
        return tas;
    }

    public void setTas(Short tas) {
        this.tas = tas;
    }

    public Short getTad() {
        return tad;
    }

    public void setTad(Short tad) {
        this.tad = tad;
    }

    public Short getAperturaOcular() {
        return aperturaOcular;
    }

    public void setAperturaOcular(Short aperturaOcular) {
        this.aperturaOcular = aperturaOcular;
    }

    public Short getRespuestaVerbal() {
        return respuestaVerbal;
    }

    public void setRespuestaVerbal(Short respuestaVerbal) {
        this.respuestaVerbal = respuestaVerbal;
    }

    public Short getRespuestaMotora() {
        return respuestaMotora;
    }

    public void setRespuestaMotora(Short respuestaMotora) {
        this.respuestaMotora = respuestaMotora;
    }

    public Short getConciencia() {
        return conciencia;
    }

    public void setConciencia(Short conciencia) {
        this.conciencia = conciencia;
    }

    public String getOtrossignos() {
        return otrossignos;
    }

    public void setOtrossignos(String otrossignos) {
        this.otrossignos = otrossignos;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    public StaticCie10 getDx() {
        return dx;
    }

    public void setDx(StaticCie10 dx) {
        this.dx = dx;
    }

    public StaticCie10 getDx1() {
        return dx1;
    }

    public void setDx1(StaticCie10 dx1) {
        this.dx1 = dx1;
    }

    public StaticCie10 getDx2() {
        return dx2;
    }

    public void setDx2(StaticCie10 dx2) {
        this.dx2 = dx2;
    }

    public StaticCie10 getDx3() {
        return dx3;
    }

    public void setDx3(StaticCie10 dx3) {
        this.dx3 = dx3;
    }

    public StaticCie10 getDx4() {
        return dx4;
    }

    public void setDx4(StaticCie10 dx4) {
        this.dx4 = dx4;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Date getFechaEvo() {
        return fechaEvo;
    }

    public void setFechaEvo(Date fechaEvo) {
        this.fechaEvo = fechaEvo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public StaticEspecialidades getIdStaticEspecialidades() {
        return idStaticEspecialidades;
    }

    public void setIdStaticEspecialidades(StaticEspecialidades idStaticEspecialidades) {
        this.idStaticEspecialidades = idStaticEspecialidades;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Date getFDigita() {
        return fDigita;
    }

    public void setFDigita(Date fDigita) {
        this.fDigita = fDigita;
    }

    public List<HcuEvoMedidasg> getHcuEvoMedidasgs() {
        return hcuEvoMedidasgs;
    }

    public void setHcuEvoMedidasgs(List<HcuEvoMedidasg> hcuEvoMedidasgs) {
        this.hcuEvoMedidasgs = hcuEvoMedidasgs;
    }

    public List<HcuEvoInterconsulta> getHcuEvoInterconsultas() {
        return hcuEvoInterconsultas;
    }

    public void setHcuEvoInterconsultas(List<HcuEvoInterconsulta> HcuEvoInterconsultas) {
        this.hcuEvoInterconsultas = HcuEvoInterconsultas;
    }

    public List<HcuEvoPosologia> getHcuEvoPosologias() {
        return hcuEvoPosologias;
    }

    public void setHcuEvoPosologias(List<HcuEvoPosologia> hcuEvoPosologias) {
        this.hcuEvoPosologias = hcuEvoPosologias;
    }
    
    public List<HcuEvoMezclasMedicamentos> getHcuEvoMezclasMedicamentoses() {
        return hcuEvoMezclasMedicamentoses;
    }

    public void setHcuEvoMezclasMedicamentoses(List<HcuEvoMezclasMedicamentos> HcuEvoMezclasMedicamentoses) {
        this.hcuEvoMezclasMedicamentoses = HcuEvoMezclasMedicamentoses;
    }

    public List<HcuEvoProcedimiento> getHcuEvoProcedimientos() {
        return hcuEvoProcedimientos;
    }

    public void setHcuEvoProcedimientos(List<HcuEvoProcedimiento> hcuEvoProcedimientos) {
        this.hcuEvoProcedimientos = hcuEvoProcedimientos;
    }

    public List<HcuEvoEgreso> getHcuEvoEgreso() {
        return hcuEvoEgreso;
    }

    public void setHcuEvoEgreso(List<HcuEvoEgreso> hcuEvoEgreso) {
        this.hcuEvoEgreso = hcuEvoEgreso;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcuEvolucion)) {
            return false;
        }
        HcuEvolucion other = (HcuEvolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MyDate_IN_ejb.HHmm.format(getFechaEvo());
    }
    
}
