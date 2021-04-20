/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jamartinez
 */
public class Factura 
{
    public int NoFactura;

    public int getNoFactura() {
        return NoFactura;
    }

    public void setNoFactura(int NoFactura) {
        this.NoFactura = NoFactura;
    }
    public String Cedula;
    public String Fecha;
    public String Vendedor;
    public String TipoCompra;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getTipoCompra() {
        return TipoCompra;
    }

    public void setTipoCompra(String TipoCompra) {
        this.TipoCompra = TipoCompra;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    public String Articulo;
    public int Cantidad;
    public int PrecioUnitario;
    public int Total;

    
}
