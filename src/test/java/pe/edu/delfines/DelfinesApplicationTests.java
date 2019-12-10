package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;


@SpringBootTest
class DelfinesApplicationTests {
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Test
	void contextLoads() {
		try {
			
			//tipo
			Tipo t1 = new Tipo();
			t1.setId("1");
			t1.setNombre("T1");
			
			Tipo t2 = new Tipo();
			t2.setId("2");
			t2.setNombre("T2");
			
			t1 = tipoRepository.save(t1);
			t2 = tipoRepository.save(t2);
			
			//vendedor
			float sueldo = Float.parseFloat("950");
			Vendedor v1 = new Vendedor();
			v1.setId("V1");
			v1.setNombre("Orlando");
			v1.setDireccion("Jr.Las manzanas");
			v1.setTelefono("123456789");
			v1.setObservacion("Bueno");
			v1.setSueldo(sueldo);
			
			float sueldo2 = Float.parseFloat("1500");
			Vendedor v2 =new Vendedor();
			v2.setId("V2");
			v2.setNombre("Andre");
			v2.setDireccion("Jr. Khalif");
			v2.setTelefono("789456123");
			v2.setObservacion("Malo");
			v2.setSueldo(sueldo2);
			
			v1 = vendedorRepository.save(v1);
			v2 = vendedorRepository.save(v2);
			
			//clientes
			Cliente c1 = new Cliente();
			c1.setDocumento("74454");
			c1.setNombre("Pedro");
			c1.setFechaNacimiento(new Date(1990, 9, 9));
			c1.setLugarNacimiento("Lima");
			c1.setSexo('M');
			c1.setObservacion("Bueno");
			
			Cliente c2 = new Cliente();
			c2.setDocumento("85217");
			c2.setNombre("Dayana");
			c2.setFechaNacimiento(new Date(1995, 10, 10));
			c2.setLugarNacimiento("Lima");
			c2.setSexo('F');
			c2.setObservacion("Maso");
			
			c1 = clienteRepository.save(c1);
			c2 = clienteRepository.save(c2);
			
			//habitaciones
			float precio3 = Float.parseFloat("40.50");
			Habitacion h1 = new Habitacion();
			h1.setNumeroCamas(1);
			h1.setDescripcion("Amplia");
			h1.setPrecio(precio3);
			h1.setObservacion("Comoda");
			
			float precio4 = Float.parseFloat("60.50");
			Habitacion h2 = new Habitacion();
			h2.setNumeroCamas(2);
			h2.setDescripcion("Matrimonial");
			h2.setPrecio(precio4);
			h2.setObservacion("Matri");
			
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			
			//alquileres
			Alquiler a1 = new Alquiler();
			a1.setPrecio(precio3);
			a1.setFecha_entrada(new Date(2019, 11, 10));
			a1.setFecha_salida(new Date(2019, 11, 10));
			a1.setEstado("Disponible");
			a1.setObservacion("Limpia");
			
			Alquiler a2 = new Alquiler();
			a2.setPrecio(precio3);
			a2.setFecha_entrada(new Date(2019, 12, 5));
			a2.setFecha_salida(new Date(2019, 12, 5));
			a2.setEstado("Disponible");
			a2.setObservacion("Limpia");
			
			a1 = alquilerRepository.save(a1);
			a2 = alquilerRepository.save(a2);
			
			//relacion habitacion-tipo
			h1.setTipo(t1);
			h2.setTipo(t2);
			
			//relacion habitacion-alquiler
			a1.setVendedor(v1);
			a1.setCliente(c1);
			a1.setHabitacion(h1);
			
			a2.setVendedor(v2);
			a2.setCliente(c2);
			a2.setHabitacion(h2);
			
			//relacion tipo-habitacion
			t1.addHabitacion(h1);
			t2.addHabitacion(h2);
			
			//relacion cliente-alquiler
			c1.addAlquiler(a1);
			c2.addAlquiler(a2);
			
			//relacion vendedor-alquiler
			v1.addAlquiler(a1);
			v2.addAlquiler(a2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
