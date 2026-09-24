/*
 * clase para manejar la informacion de cliente
 */
package entidades;

/**
 * Clase para representar un paciente.
 */
public class Paciente {

    private int id;
    private String lastName;
    private String name;
    private String domicilio;
    private int document;
    private int id_obrasocial;
    private String provincia;
    private String email;
    private String movils;

    // Constructor completo
    public Paciente(int id, String lastName, String name, String domicilio, int document, int id_obrasocial, String provincia, String movils, String email) {
        this.setId(id);
        this.setLastName(lastName);
        this.setName(name);
        this.setDomicilio(domicilio);
        this.setDocument(document);
        this.setId_obrasocial(id_obrasocial);
        this.setProvincia(provincia);
        this.setMovils(movils);
        this.setEmail(email);
    }

    // Constructor por defecto
    public Paciente() {
        this.setId(0);
        this.setLastName("");
        this.setName("");
        this.setDomicilio("");
        this.setDocument(0);
        this.setId_obrasocial(0);
        this.setProvincia("");
        this.setEmail("");
        this.setMovils("");
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public int getId_obrasocial() {
        return id_obrasocial;
    }

    public void setId_obrasocial(int id_obrasocial) {
        this.id_obrasocial = id_obrasocial;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovils() {
        return movils;
    }

    public void setMovils(String movils) {
        this.movils = movils;
    }

    // Método para convertir los datos del paciente a un arreglo de objetos
    public Object[] toObject() {
        return new Object[]{
            getId(),
            getLastName(),
            getName(),
            getDomicilio(),
            getDocument(),
            getId_obrasocial(),
            getProvincia(),
            getMovils(),
            getEmail()
        };
    }
}
