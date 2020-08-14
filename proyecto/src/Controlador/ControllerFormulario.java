/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jose Roque
 */
public class ControllerFormulario implements ActionListener {
    
    Usuario usuario = new Usuario();
    Login login = new Login();
    DatosVO dvo = new DatosVO();
    DatosDAO ddao = new DatosDAO();
    
    public ControllerFormulario(Usuario usuario, Login login, DatosVO dvo, DatosDAO ddao) {
        this.usuario = usuario;
        this.login = login;
        this.dvo = dvo;
        this.ddao = ddao;
        
        usuario.f_btn_buscarCliente.addActionListener(this);
    }
    
    private void buscarCliente() {
        
        String valorBuscado = (String) usuario.f_valor_buscado.getSelectedItem();
        
        switch (valorBuscado) {
            case "Nombre":
                buscarNombre();
                break;
            case "Telefono":
                buscarTelefono();
                break;
            case "Correo":
                buscarCorreo();
                break;
            default:
                login.mensaje.showMessageDialog(null, "Por favor indicar el tipo de busqueda");
                usuario.f_txt_buscarCliente.setText("");
                break;
        }
        
        registroDetallado();
        
    }
    
    private void buscarNombre() {
        dvo.setBuscar_nombre(usuario.f_txt_buscarCliente.getText().trim());
        ddao.mostrar_datos_nombre(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setText(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setText(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setText(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }
    
    private void buscarTelefono() {
        dvo.setBuscar_telefono(usuario.f_txt_buscarCliente.getText());
        ddao.mostrar_datos_telefono(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setText(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setText(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setText(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }
    
    private void buscarCorreo() {
        dvo.setBuscar_correo(usuario.f_txt_buscarCliente.getText().trim());
        ddao.mostrar_datos_correo(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setText(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setText(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setText(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }
    
    private void registroDetallado(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuario.f_btn_buscarCliente) {
            buscarCliente();
        }
        
    }
    
}
