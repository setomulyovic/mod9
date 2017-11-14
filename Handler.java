
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Praktikum
 */
public class Handler extends MouseAdapter implements ActionListener{
    private ArrayList<Peserta> daftarPeserta;
    private GUI view;
    
    
    public Handler(){
        daftarPeserta = new ArrayList();
        view = new GUI();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setId(Peserta.getId());
        view.setVisible(true);
       
    }
    private java.lang.String[] getDaftarPeserta(){
        String[] daftarID = new String[daftarPeserta.size()];
        for (int i = 0; i < daftarID.length; i++) {
            daftarID[i] = daftarPeserta.get(i).getIdPeserta();
         
        }
        return daftarID;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())){
            String nama = view.getNama();
            char jenisKelamin = view.getJenisKelamin();
            ArrayList<String> pelajaran = view.getPelajaran();
            String jadwal = view.getJadwal();
            Peserta p = new Peserta (nama,jenisKelamin, pelajaran, jadwal);
            daftarPeserta.add(p);
            view.resetView();
            view.setId(Peserta.getId());
            view.setDaftarPeserta(getDaftarPeserta());
            
        }
        else if (source.equals(view.getBtnDelete())){
            int i = view.getSelectedPeserta();
            daftarPeserta.remove(i);
            view.resetView();
            view.setId(Peserta.getId());
            view.setDaftarPeserta(getDaftarPeserta());
        }}
        
    @Override
        public void mousePressed (MouseEvent me){
            Object source = me.getSource();
            if (source.equals(view.getListPeserta())) {
                int i = view.getSelectedPeserta();
                Peserta p = daftarPeserta.get(i);
                view.setTextPeserta(p.toString());
                
            }
            
        }
    }
    
    
    
    

