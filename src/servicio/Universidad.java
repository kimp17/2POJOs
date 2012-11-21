package servicio;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService (targetNamespace ="http://service", name="universidad")
public class Universidad {

  private ProfesorService profesor;
  private GrupoService grupo;

  @WebMethod (action="urn:findProfesor", operationName="findProfesor")
  public ProfesorDTO findProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    return profesor.find(profesorId);
  }

  @WebMethod (action="urn:findAllProfesor", operationName="findAllProfesor")
  public List<ProfesorDTO> findAllProfesor() {
    checkProfesor();
    return profesor.findAll();
  }

  private void checkProfesor() {
    if (profesor == null)
      profesor = new ProfesorService();
  }
  
  @WebMethod (action="urn:findGrupo", operationName="findGrupo")
  public GrupoDTO findGrupo(@WebParam (partName = "grupoId") String grupoId) {
    checkGrupo();
    return grupo.find(grupoId);
  }

  @WebMethod (action="urn:findAllGrupos", operationName="findAllGrupos")
  public List<GrupoDTO> findAllGrupos() {
    checkGrupo();
    return grupo.findAll();
  }

  private void checkGrupo() {
    if (grupo == null)
      grupo = new GrupoService();
  }
}