package yqc.ebook.service.impl;

import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.dao.BookDao;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;
import yqc.ebook.service.BookService;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import yqc.ebook.service.WordCount;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Iterable<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findOne(Integer id) {
        return bookDao.findOne(id);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public void save(Book b) {bookDao.save(b);}

    @Override
    public void delete(Integer id) { bookDao.delete(id);}

    @Override
    public BookComment findCommentByIsbn(String isbn) {return bookDao.findCommentByIsbn(isbn);}

    @Override
    public void saveComment(BookComment bookComment) {bookDao.saveComment(bookComment);}

    @Override
    public void printBrief() throws InterruptedException, IOException, ClassNotFoundException {
        Configuration conf = new Configuration();
        conf.set("dfs.defaultFS", "hdfs://hadoop:9000");
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(WordCount.TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path("../resources/input1"));
        FileOutputFormat.setOutputPath(job, new Path("../resources/output1"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
