package com.mhb.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class StudentReportPDFView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		List<String> studList=null;
		Paragraph p=null;
		Table t=null;
		//read model Attribule data
		studList=(List<String>)map.get("stList");
		p=new Paragraph("Student Detials");
		p.setAlignment("center");
		p.setFont(new Font(Font.BOLD));
        doc.add(p);
        t=new Table(1);
        for(String name:studList){
        	t.addCell(name+" ");
        }
        doc.add(t);
	}

}
