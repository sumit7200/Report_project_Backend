package com.report.project.serviceImpl;

import com.report.project.entity.Report;
import com.report.project.repository.ReportRepository;
import com.report.project.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // fetch All Data
    @Override
    public List<Report> getAllReport() {
        return reportRepository.findAll();
    }

    //filtered Data Start Date To End Date
    @Override
    public List<Report> getFilteredReports(LocalDate startDate, LocalDate endDate) {
        return reportRepository.findByDateBetween(startDate, endDate);
    }

    //fetch Data By Id
    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    //save Data
    @Override
    public Report CreateReport(Report report) throws Exception {
        //report.setDate(LocalDateTime.now());
        return reportRepository.saveAndFlush(report);
    }

    //update Data By Id
    @Override
    public Report updateReport(Long id, Report report) {
        report.setId(id);
        return reportRepository.saveAndFlush(report);
    }

    //delete Data By Id
    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
